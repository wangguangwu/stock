package com.wangguangwu.datatushare.service.quotes.impl;

import com.wangguangwu.datatushare.service.quotes.MarketQuotesService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarketQuotesServiceImplTest {

    @Resource
    private MarketQuotesService marketDataService;

    @Test
    void dailyMarketService() {
        marketDataService.dailyMarketQuotes();
    }

    @Test
    void weeklyMarketQuotes() {
        marketDataService.weeklyMarketQuotes();
    }
}