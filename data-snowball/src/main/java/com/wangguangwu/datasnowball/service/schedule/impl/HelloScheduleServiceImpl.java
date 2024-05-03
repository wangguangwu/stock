package com.wangguangwu.datasnowball.service.schedule.impl;

import cn.hutool.core.collection.CollUtil;
import com.wangguangwu.datasnowball.service.f10.TopHolderService;
import com.wangguangwu.datasnowball.service.realtime.RealTimeService;
import com.wangguangwu.datasnowball.service.schedule.HelloScheduleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class HelloScheduleServiceImpl implements HelloScheduleService {

    @Resource
    private TopHolderService topHolderService;
    @Resource
    private RealTimeService realTimeService;

    @Override
    public void updateTradeInfo() {
        List<String> symbolList = topHolderService.listTopHolderInfo("社保", "主板");
        symbolList.addAll(topHolderService.listTopHolderInfo("养老", "主板"));
        if (CollUtil.isEmpty(symbolList)) {
            return;
        }
        Map<String, Boolean> errorMap = new HashMap<>();
        for (String symbol : symbolList) {
            try {
                boolean kline = realTimeService.kline(symbol, 90);
                if (Boolean.FALSE.equals(kline)) {
                    errorMap.put(symbol, kline);
                }
            } catch (Exception e) {
                e.printStackTrace();
                errorMap.put(symbol, false);
            }
        }
        for (Map.Entry<String, Boolean> entry : errorMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
