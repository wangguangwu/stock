package com.wangguangwu.datatushare.component.quotes;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.MarketQuotes;
import com.wangguangwu.datatushare.entity.DailyMarketQuotesDO;
import com.wangguangwu.datatushare.service.basic.DailyMarketQuotesService;
import com.wangguangwu.datatushare.util.ConvertUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

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
    protected void saveOrUpdateBatch(List<DailyMarketQuotesDO> list) {
        dailyMarketQuotesService.saveOrUpdateBatch(list);
    }

    @Override
    protected List<DailyMarketQuotesDO> convertItemToDataObject(String json) {
        List<MarketQuotes> marketQuotes = ConvertUtil.convertJsonToObjects(json, MarketQuotes.class);
        return marketQuotes.stream().map(this::getDailyMarketQuotesDO).toList();
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
