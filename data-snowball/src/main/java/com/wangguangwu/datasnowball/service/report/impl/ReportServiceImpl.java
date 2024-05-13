package com.wangguangwu.datasnowball.service.report.impl;

import com.wangguangwu.datasnowball.service.report.ReportFetchService;
import com.wangguangwu.datasnowball.service.report.ReportSaveService;
import com.wangguangwu.datasnowball.service.report.ReportService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

    @Resource
    private ReportFetchService fetchService;
    @Resource
    private ReportSaveService saveService;

    @Override
    public boolean latest(String symbol) {
        String json = fetchService.latestFetch(symbol);
        return saveService.latestSave(symbol, json);
    }

    @Override
    public boolean earningForecast(String symbol) {
        String json = fetchService.earningForecastFetch(symbol);
        return saveService.earningForecastSave(symbol, json);
    }
}
