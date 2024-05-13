package com.wangguangwu.datasnowball.service.report.impl;

import com.wangguangwu.datasnowball.component.HttpFetcherComponent;
import com.wangguangwu.datasnowball.constant.ReportUrlConstant;
import com.wangguangwu.datasnowball.service.report.ReportFetchService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author wangguangwu
 */
@Service
@Slf4j
public class ReportFetchServiceImpl implements ReportFetchService {

    @Resource
    private HttpFetcherComponent fetcherComponent;

    @Override
    public String latestFetch(String symbol) {
        return fetchData(ReportUrlConstant.REPORT_LATEST_URL, symbol);
    }

    @Override
    public String earningForecastFetch(String symbol) {
        return fetchData(ReportUrlConstant.REPORT_EARNING_FORECAST_URL, symbol);
    }

    //=====================================私有方法==========================================

    private String fetchData(String baseUrl, String symbol) {
        return fetcherComponent.fetch(baseUrl + symbol);
    }
}
