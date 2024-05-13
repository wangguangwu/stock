package com.wangguangwu.datasnowball.controller;

import com.wangguangwu.datasnowball.service.report.ReportFetchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguangwu
 */

@RestController
@RequestMapping("report")
public class ReportController {

    @Resource
    private ReportFetchService reportFetchService;

    /**
     * 获取指定股票代码的最新财务报告。
     *
     * @param symbol 股票代码
     * @return 财务报告数据
     */
    @GetMapping("/latest/{symbol}")
    public String getLatestReport(@PathVariable String symbol) {
        return reportFetchService.latestFetch(symbol);
    }

    /**
     * 获取指定股票代码的盈利预测报告。
     *
     * @param symbol 股票代码
     * @return 盈利预测报告数据
     */
    @GetMapping("/earningForecast/{symbol}")
    public String getEarningForecastReport(@PathVariable String symbol) {
        return reportFetchService.earningForecastFetch(symbol);
    }
}
