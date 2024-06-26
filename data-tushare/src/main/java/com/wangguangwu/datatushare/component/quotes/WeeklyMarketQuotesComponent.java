package com.wangguangwu.datatushare.component.quotes;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.TuShareDataComponent;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.MarketQuotes;
import com.wangguangwu.datatushare.entity.WeeklyMarketQuotesDO;
import com.wangguangwu.datatushare.service.basic.WeeklyMarketQuotesService;
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
public class WeeklyMarketQuotesComponent extends TuShareDataComponent<WeeklyMarketQuotesDO> {

    @Resource
    private WeeklyMarketQuotesService weeklyMarketQuotesService;

    @Override
    protected JSONObject createBasicRequestBody() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.set("api_name", "weekly");

        jsonBody.set("fields", QueryFieldsConstant.MARKET_DATA_FIELDS);
        return jsonBody;
    }

    @Override
    protected boolean saveOrUpdateBatch(List<WeeklyMarketQuotesDO> list) {
        return weeklyMarketQuotesService.saveOrUpdateBatch(list);
    }

    @Override
    protected List<WeeklyMarketQuotesDO> convertItemToDataObject(String json) {
        List<MarketQuotes> marketQuotes = ConvertUtil.convertJsonToObjects(json, MarketQuotes.class);
        return marketQuotes.stream().map(this::getWeeklyMarketQuotesDO).toList();
    }

    private WeeklyMarketQuotesDO getWeeklyMarketQuotesDO(MarketQuotes marketQuotes) {
        WeeklyMarketQuotesDO weeklyMarketQuotesDO = ConvertUtil.convertSourceToTarget(marketQuotes, WeeklyMarketQuotesDO.class);
        weeklyMarketQuotesDO.setOpen(parseBigDecimal(marketQuotes.getOpen()));
        weeklyMarketQuotesDO.setHigh(parseBigDecimal(marketQuotes.getHigh()));
        weeklyMarketQuotesDO.setLow(parseBigDecimal(marketQuotes.getLow()));
        weeklyMarketQuotesDO.setClose(parseBigDecimal(marketQuotes.getClose()));
        weeklyMarketQuotesDO.setPreClose(parseBigDecimal(marketQuotes.getPreClose()));
        weeklyMarketQuotesDO.setTsChange(parseBigDecimal(marketQuotes.getChange()));
        weeklyMarketQuotesDO.setPctChg(parseBigDecimal(marketQuotes.getPctChg()));
        weeklyMarketQuotesDO.setVol(parseBigDecimal(marketQuotes.getVol()));
        weeklyMarketQuotesDO.setAmount(parseBigDecimal(marketQuotes.getAmount()));

        weeklyMarketQuotesDO.setTradeDate(parseDate(marketQuotes.getTradeDate()));
        return weeklyMarketQuotesDO;
    }
}
