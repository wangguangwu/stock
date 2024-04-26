package com.wangguangwu.datatushare.service.impl;

import com.wangguangwu.datatushare.service.stock.StockService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StockServiceImplTest {

    @Resource
    private StockService stockService;

    @Test
    void stockBasicItem() {
        stockService.stockBasicItem();
    }
}