package com.wangguangwu.datatushare.component.quotes;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.MarketQuotes;
import com.wangguangwu.datatushare.entity.DailyMarketQuotesDO;
import com.wangguangwu.datatushare.service.basic.DailyMarketQuotesService;
import com.wangguangwu.datatushare.util.ConvertUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
@Component
@Slf4j
public class DailyMarketQuotesComponent extends TuShareDataComponent<DailyMarketQuotesDO> {

    @Resource
    private DailyMarketQuotesService dailyMarketQuotesService;

    @Override
    protected JSONObject createBasicRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "daily");

        jsonBody.set("fields", QueryFieldsConstant.MARKET_DATA_FIELDS);
        return jsonBody;
    }

    @Override
    protected boolean saveOrUpdateBatch(List<DailyMarketQuotesDO> list) {
        if (CollUtil.isEmpty(list)) {
            return true;
        }
        Set<LocalDate> tradeDateSet = getExistsTradeDate(list);
        List<DailyMarketQuotesDO> result = list.stream().filter(dailyMarketQuotesDO -> !tradeDateSet.contains(dailyMarketQuotesDO.getTradeDate())).toList();
        return dailyMarketQuotesService.saveOrUpdateBatch(result);
    }

    @Override
    protected List<DailyMarketQuotesDO> convertItemToDataObject(String json) {
        List<MarketQuotes> marketQuotes = ConvertUtil.convertJsonToObjects(json, MarketQuotes.class);
        return marketQuotes.stream().map(this::getDailyMarketQuotesDO).toList();
    }

    //=====================================私有方法==========================================

    private Set<LocalDate> getExistsTradeDate(List<DailyMarketQuotesDO> list) {
        String tsCode = list.get(0).getTsCode();
        Set<LocalDate> tradeDateSet = list.stream().map(DailyMarketQuotesDO::getTradeDate).collect(Collectors.toSet());
        LambdaQueryWrapper<DailyMarketQuotesDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(DailyMarketQuotesDO::getTsCode, tsCode)
                .in(DailyMarketQuotesDO::getTradeDate, tradeDateSet)
                .select(DailyMarketQuotesDO::getTradeDate);
        return dailyMarketQuotesService.list(queryWrapper).stream()
                .map(DailyMarketQuotesDO::getTradeDate).collect(Collectors.toSet());
    }

    private DailyMarketQuotesDO getDailyMarketQuotesDO(MarketQuotes marketQuotes) {
        DailyMarketQuotesDO dailyMarketQuotesDO = ConvertUtil.convertSourceToTarget(marketQuotes, DailyMarketQuotesDO.class);
        dailyMarketQuotesDO.setOpen(parseBigDecimal(marketQuotes.getOpen()));
        dailyMarketQuotesDO.setHigh(parseBigDecimal(marketQuotes.getHigh()));
        dailyMarketQuotesDO.setLow(parseBigDecimal(marketQuotes.getLow()));
        dailyMarketQuotesDO.setClose(parseBigDecimal(marketQuotes.getClose()));
        dailyMarketQuotesDO.setPreClose(parseBigDecimal(marketQuotes.getPreClose()));
        dailyMarketQuotesDO.setTsChange(parseBigDecimal(marketQuotes.getChange()));
        dailyMarketQuotesDO.setPctChg(parseBigDecimal(marketQuotes.getPctChg()));
        dailyMarketQuotesDO.setVol(parseBigDecimal(marketQuotes.getVol()));
        dailyMarketQuotesDO.setAmount(parseBigDecimal(marketQuotes.getAmount()));

        dailyMarketQuotesDO.setTradeDate(parseDate(marketQuotes.getTradeDate()));
        return dailyMarketQuotesDO;
    }
}
