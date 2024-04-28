package com.wangguangwu.datatushare.service.quotes.impl;

import com.wangguangwu.datatushare.service.quotes.MarketQuotesService;
import com.wangguangwu.datatushare.util.DateFormatUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarketQuotesServiceImplTest {

    @Resource
    private MarketQuotesService marketDataService;

    @Test
    void dailyMarketService() {
//        marketDataService.dailyMarketQuotes();
    }

    @Test
    void weeklyMarketQuotes() {
//        marketDataService.weeklyMarketQuotes();
    }

    @Test
    void dailyBasic() {
//        marketDataService.dailyBasic();
    }

    @Test
    void bakDaily() {
        marketDataService.bakDaily("601318.SH", DateFormatUtil.formatYYYYMMDD(), DateFormatUtil.formatYYYYMMDD(), "", "", "");
    }
}