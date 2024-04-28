package com.wangguangwu.datatushare.service.quotes.impl;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.quotes.DailyBasicComponent;
import com.wangguangwu.datatushare.component.quotes.DailyMarketQuotesComponent;
import com.wangguangwu.datatushare.component.quotes.WeeklyMarketQuotesComponent;
import com.wangguangwu.datatushare.service.quotes.MarketQuotesService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class MarketQuotesServiceImpl implements MarketQuotesService {

    @Resource
    private DailyMarketQuotesComponent dailyMarketQuotesComponent;

    @Resource
    private WeeklyMarketQuotesComponent weeklyMarketQuotesComponent;

    @Resource
    private DailyBasicComponent dailyBasicComponent;

    @Override
    public void dailyMarketQuotes() {
        JSONObject params = new JSONObject();
        params.set("ts_code", "000001.SZ");
        params.set("start_date", "20180701");
        params.set("end_date", "20180718");
        dailyMarketQuotesComponent.setParams(params);
        dailyMarketQuotesComponent.fetchAndSaveData("A股每日行情");
    }

    @Override
    public void weeklyMarketQuotes() {
        JSONObject params = new JSONObject();
        params.set("ts_code", "000001.SZ");
        params.set("start_date", "20180701");
        params.set("end_date", "20180718");
        weeklyMarketQuotesComponent.setParams(params);
        weeklyMarketQuotesComponent.fetchAndSaveData("A股每周行情");
    }

    @Override
    public void dailyBasic() {
        JSONObject params = new JSONObject();
        params.set("ts_code", "000001.SZ");
        params.set("start_date", "20240426");
        params.set("end_date", "20240426");
        dailyBasicComponent.setParams(params);
        dailyBasicComponent.fetchAndSaveData("A股每日指标");
    }
}
