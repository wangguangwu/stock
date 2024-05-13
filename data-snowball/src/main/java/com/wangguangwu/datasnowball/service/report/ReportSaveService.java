package com.wangguangwu.datasnowball.service.report;

/**
 * @author wangguangwu
 */
public interface ReportSaveService {

    /**
     * 保存公司最新的财务报告。。
     *
     * @param symbol 股票代码
     * @param json   json 报文
     * @return 是否更新成功
     */
    boolean latestSave(String symbol, String json);

    /**
     * 保存公司的盈利预测报告。
     *
     * @param symbol 股票代码
     * @param json   json 报文
     * @return 是否更新成功
     */
    boolean earningForecastSave(String symbol, String json);

}
