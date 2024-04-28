package com.wangguangwu.datatushare.service.quotes.impl;

import cn.hutool.json.JSONObject;
import com.wangguangwu.datatushare.component.quotes.BakDailyComponent;
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
    @Resource
    private BakDailyComponent bakDailyComponent;

    @Override
    public void dailyMarketQuotes(String tsCode, String startDate, String endDate) {
        dailyMarketQuotesComponent.setParams(getParams(tsCode, startDate, endDate));
        dailyMarketQuotesComponent.fetchAndSaveData("A股每日行情");
    }


    @Override
    public void weeklyMarketQuotes(String tsCode, String startDate, String endDate) {
        weeklyMarketQuotesComponent.setParams(getParams(tsCode, startDate, endDate));
        weeklyMarketQuotesComponent.fetchAndSaveData("A股每周行情");
    }

    @Override
    public void dailyBasic(String tsCode, String startDate, String endDate) {
        dailyBasicComponent.setParams(getParams(tsCode, startDate, endDate));
        dailyBasicComponent.fetchAndSaveData("A股每日指标");
    }

    @Override
    public void bakDaily(String tsCode, String tradeDate, String startDate, String endDate, String offset, String limit) {
        bakDailyComponent.setParams(getParams(tsCode, startDate, endDate));
        bakDailyComponent.fetchAndSaveData("A股备用行情");
    }

    private static JSONObject getParams(String tsCode, String startDate, String endDate) {
        JSONObject params = new JSONObject();
        params.set("ts_code", tsCode);
        params.set("start_date", startDate);
        params.set("end_date", endDate);
        return params;
    }
}
