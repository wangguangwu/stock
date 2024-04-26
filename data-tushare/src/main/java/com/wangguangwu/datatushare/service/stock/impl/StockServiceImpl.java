package com.wangguangwu.datatushare.service.stock.impl;

import com.wangguangwu.datatushare.component.stock.StockBasicComponent;
import com.wangguangwu.datatushare.service.stock.StockService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {

    @Resource
    private StockBasicComponent stockBasicHandleComponent;

    @Override
    public void stockBasicItem() {
        stockBasicHandleComponent.fetchAndSaveData("股市基本数据");
    }
}
