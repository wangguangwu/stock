package com.wangguangwu.datatushare.service.quotes.impl;

import com.wangguangwu.datatushare.component.DailyMarketDataHandleComponent;
import com.wangguangwu.datatushare.service.quotes.MarketDataService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class MarketDataServiceImpl implements MarketDataService {

    @Resource
    private DailyMarketDataHandleComponent dailyMarketDataHandleComponent;

    @Override
    public void dailyMarketService() {
        dailyMarketDataHandleComponent.fetchAndSaveData("A股每日行情");
    }
}
