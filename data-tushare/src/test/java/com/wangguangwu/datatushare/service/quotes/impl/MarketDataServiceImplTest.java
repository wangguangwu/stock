package com.wangguangwu.datatushare.service.quotes.impl;

import com.wangguangwu.datatushare.service.quotes.MarketDataService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarketDataServiceImplTest {

    @Resource
    private MarketDataService marketDataService;

    @Test
    void dailyMarketService() {
        marketDataService.dailyMarketService();
    }
}