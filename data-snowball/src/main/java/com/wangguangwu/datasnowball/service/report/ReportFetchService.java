package com.wangguangwu.datasnowball.service.report;

import com.wangguangwu.datasnowball.constant.ReportUrlConstant;

/**
 * 获取报告数据接口
 * <p>
 * {@link ReportUrlConstant} 报告数据 url
 *
 * @author wangguangwu
 */
public interface ReportFetchService {

    /**
     * 获取公司最新的财务报告。
     *
     * @param symbol 股票代码
     * @return 最新的财务报告数据
     */
    String latestFetch(String symbol);

    /**
     * 获取公司的盈利预测报告。
     *
     * @param symbol 股票代码
     * @return 盈利预测报告数据
     */
    String earningForecastFetch(String symbol);

}
