package com.wangguangwu.datatushare.service.quotes.impl;

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
        dailyMarketQuotesComponent.fetchAndSaveData("A股每日行情");
    }

    @Override
    public void weeklyMarketQuotes() {
        weeklyMarketQuotesComponent.fetchAndSaveData("A股每周行情");
    }

    @Override
    public void dailyBasic() {
        dailyBasicComponent.fetchAndSaveData("A股每日指标");
    }
}
