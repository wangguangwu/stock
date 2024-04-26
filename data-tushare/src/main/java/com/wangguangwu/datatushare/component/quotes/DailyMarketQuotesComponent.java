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
    protected JSONObject getParams() {
        JSONObject params = new JSONObject();
        params.set("ts_code", "000001.SZ");
        params.set("start_date", "20180701");
        params.set("end_date", "20180718");
        return params;
    }

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
    protected DailyMarketQuotesDO convertItemToDataObject(List<String> item) {
        MarketQuotes marketQuotes = new MarketQuotes(
                item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
                item.get(6), item.get(7), item.get(8), item.get(9), item.get(10)
        );
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
