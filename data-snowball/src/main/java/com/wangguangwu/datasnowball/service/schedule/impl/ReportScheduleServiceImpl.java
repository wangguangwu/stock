package com.wangguangwu.datasnowball.service.schedule.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson2.JSON;
import com.wangguangwu.datasnowball.component.StockBasicComponent;
import com.wangguangwu.datasnowball.service.report.ReportService;
import com.wangguangwu.datasnowball.service.schedule.ReportScheduleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ReportScheduleServiceImpl implements ReportScheduleService {

    @Resource
    private ReportService reportService;
    @Resource
    private StockBasicComponent stockBasicComponent;

    @Override
    public void updateLatestReports() {
        List<String> symbolList = stockBasicComponent.getSymbolList();
        if (CollUtil.isEmpty(symbolList)) {
            return;
        }
        Set<String> errorSet = new HashSet<>();
        for (String symbol : symbolList) {
            try {
                boolean succeed = reportService.latest(symbol);
                if (!succeed) {
                    errorSet.add(symbol);
                }
            } catch (Exception e) {
                errorSet.add(symbol);
            }
        }
        if (CollUtil.isNotEmpty(errorSet)) {
            log.error("获取公司最新的财务报告失败名单: {}", JSON.toJSON(errorSet));
        }
    }

    @Override
    public void updateEarningForecasts() {
        List<String> symbolList = stockBasicComponent.getSymbolList();
        if (CollUtil.isEmpty(symbolList)) {
            return;
        }
        Set<String> errorSet = new HashSet<>();
        for (String symbol : symbolList) {
            try {
                boolean succeed = reportService.earningForecast(symbol);
                if (!succeed) {
                    errorSet.add(symbol);
                }
            } catch (Exception e) {
                errorSet.add(symbol);
            }
        }
        if (CollUtil.isNotEmpty(errorSet)) {
            log.error("获取公司最新的财务报告失败名单: {}", JSON.toJSON(errorSet));
        }
    }
}
