package com.wangguangwu.datatushare.service.impl;

import com.wangguangwu.datatushare.component.StockBasicHandleComponent;
import com.wangguangwu.datatushare.service.StockService;
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
    private StockBasicHandleComponent stockBasicHandleComponent;

    @Override
    public void stockBasicItem() {
        stockBasicHandleComponent.fetchAndSaveData("股市基本数据");
    }
}
