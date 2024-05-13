package com.wangguangwu.datasnowball.service.schedule.impl;

import cn.hutool.core.collection.CollUtil;
import com.wangguangwu.datasnowball.component.StockBasicComponent;
import com.wangguangwu.datasnowball.service.f10.F10Service;
import com.wangguangwu.datasnowball.service.schedule.F10ScheduleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class F10ScheduleServiceImpl implements F10ScheduleService {

    @Resource
    private F10Service f10Service;
    @Resource
    private StockBasicComponent stockBasicComponent;

    @Override
    public void updateTopHolders() {
        List<String> symbolList = stockBasicComponent.getSymbolList();
        if (CollUtil.isEmpty(symbolList)) {
            return;
        }
        Map<String, Boolean> symbolMap = new HashMap<>();
        symbolList.forEach(symbol -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                boolean succeed = f10Service.topHolders(symbol, 1);
                symbolMap.put(symbol, succeed);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(symbolMap);
    }

    @Override
    public void updateMainIndicators() {
        List<String> symbolList = stockBasicComponent.getSymbolList();
        if (CollUtil.isEmpty(symbolList)) {
            return;
        }
        Map<String, Boolean> symbolMap = new HashMap<>();
        symbolList.forEach(symbol -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                boolean succeed = f10Service.mainIndicator(symbol);
                if (!succeed) {
                    symbolMap.put(symbol, succeed);
                }
            } catch (Exception e) {
                e.printStackTrace();
                symbolMap.put(symbol, false);
            }
        });
        System.out.println(symbolMap);
    }
}
