package com.wangguangwu.datasnowball.service.report;

/**
 * @author wangguangwu
 */
public interface ReportService {

    /**
     * 获取公司最新的财务报告。
     *
     * @param symbol 股票代码
     * @return 是否保存成功
     */
    boolean latest(String symbol);

    /**
     * 获取公司的盈利预测报告。
     *
     * @param symbol 股票代码
     * @return 是否保存成功
     */
    boolean earningForecast(String symbol);

}
