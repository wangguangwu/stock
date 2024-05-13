package com.wangguangwu.datasnowball.service.schedule;

/**
 * @author wangguangwu
 */
public interface ReportScheduleService {

    /**
     * 获取指定股票代码的最新财务报告。
     */
    void updateLatestReports();

    /**
     * 获取公司的盈利预测报告。
     */
    void updateEarningForecasts();

}
