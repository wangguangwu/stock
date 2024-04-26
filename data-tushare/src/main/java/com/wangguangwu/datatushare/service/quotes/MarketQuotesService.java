package com.wangguangwu.datatushare.service.quotes;

/**
 * 行情服务
 *
 * @author wangguangwu
 */
public interface MarketQuotesService {

    /**
     * 日线行情数据
     */
    void dailyMarketQuotes();

    /**
     * 周线行情
     */
    void weeklyMarketQuotes();

}
