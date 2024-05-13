package com.wangguangwu.datatushare.service.quotes;

/**
 * 行情服务
 *
 * @author wangguangwu
 */
public interface MarketQuotesService {

    /**
     * 获取并且保存日线行情数据
     *
     * @param tsCode    股票代码
     * @param tradeDate 交易日期
     * @param startDate 起期
     * @param endDate   止期
     * @return 是否保存成功
     */
    boolean dailyMarketQuotes(String tsCode, String tradeDate, String startDate, String endDate);

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

    /**
     * 行情数据 - 备用行情
     *
     * @param tsCode    股票代码
     * @param tradeDate 交易日期
     * @param startDate 开始日期
     * @param endDate   结束日期
     */
    void bakDaily(String tsCode, String tradeDate, String startDate, String endDate);

}
