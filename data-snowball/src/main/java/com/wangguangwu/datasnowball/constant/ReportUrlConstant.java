package com.wangguangwu.datasnowball.constant;

/**
 * 报告数据
 *
 * @author wangguangwu
 */
public final class ReportUrlConstant {

    /**
     * 获取公司最新的财务报告。
     */
    public static final String REPORT_LATEST_URL = "https://stock.xueqiu.com/stock/report/latest.json?symbol=";

    /**
     * 获取公司的盈利预测报告。
     */
    public static final String REPORT_EARNING_FORECAST_URL = "https://stock.xueqiu.com/stock/report/earningforecast.json?symbol=";


    private ReportUrlConstant() {
    }
}
