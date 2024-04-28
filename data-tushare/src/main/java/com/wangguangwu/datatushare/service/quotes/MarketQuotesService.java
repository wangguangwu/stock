package com.wangguangwu.datatushare.service.quotes;

/**
 * 行情服务
 *
 * @author wangguangwu
 */
public interface MarketQuotesService {

    /**
     * 日线行情数据
     *
     * @param tsCode    股票代码
     * @param startDate 起期
     * @param endDate   止期
     */
    void dailyMarketQuotes(String tsCode, String startDate, String endDate);

    /**
     * 周线行情
     *
     * @param tsCode    股票代码
     * @param startDate 起期
     * @param endDate   止期
     */
    void weeklyMarketQuotes(String tsCode, String startDate, String endDate);

    /**
     * 行情数据 - 每日指标
     *
     * @param tsCode    股票代码
     * @param startDate 起期
     * @param endDate   止期
     */
    void dailyBasic(String tsCode, String startDate, String endDate);

}
