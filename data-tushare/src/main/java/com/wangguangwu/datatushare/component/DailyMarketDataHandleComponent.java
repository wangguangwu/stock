package com.wangguangwu.datatushare.component;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.constant.QueryFieldsConstant;
import com.wangguangwu.datatushare.dto.MarketData;
import com.wangguangwu.datatushare.entity.DailyMarketDataDO;
import com.wangguangwu.datatushare.service.basic.DailyMarketDataService;
import com.wangguangwu.datatushare.template.TuShareDataHandleComponent;
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
public class DailyMarketDataHandleComponent extends TuShareDataHandleComponent<DailyMarketDataDO> {

    @Resource
    private DailyMarketDataService dailyMarketDataService;

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
    protected void saveOrUpdateBatch(List<DailyMarketDataDO> list) {
        dailyMarketDataService.saveOrUpdateBatch(list);
    }

    @Override
    protected DailyMarketDataDO convertItemToDataObject(List<String> item) {
        MarketData marketData = new MarketData(
                item.get(0), item.get(1), item.get(2), item.get(3), item.get(4), item.get(5),
                item.get(6), item.get(7), item.get(8), item.get(9), item.get(10)
        );
        DailyMarketDataDO dailyMarketDataDO = ConvertUtil.convertSourceToTarget(marketData, DailyMarketDataDO.class);
        dailyMarketDataDO.setOpen(parseBigDecimal(marketData.getOpen()));
        dailyMarketDataDO.setHigh(parseBigDecimal(marketData.getHigh()));
        dailyMarketDataDO.setLow(parseBigDecimal(marketData.getLow()));
        dailyMarketDataDO.setClose(parseBigDecimal(marketData.getClose()));
        dailyMarketDataDO.setPreClose(parseBigDecimal(marketData.getPreClose()));
        dailyMarketDataDO.setTsChange(parseBigDecimal(marketData.getChange()));
        dailyMarketDataDO.setPctChg(parseBigDecimal(marketData.getPctChg()));
        dailyMarketDataDO.setVol(parseBigDecimal(marketData.getVol()));
        dailyMarketDataDO.setAmount(parseBigDecimal(marketData.getAmount()));

        dailyMarketDataDO.setTradeDate(parseDate(marketData.getTradeDate()));
        return dailyMarketDataDO;
    }
}
