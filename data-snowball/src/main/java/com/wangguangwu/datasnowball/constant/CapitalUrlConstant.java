package com.wangguangwu.datasnowball.constant;

/**
 * 资本市场数据
 *
 * @author wangguangwu
 */
public final class CapitalUrlConstant {

    /**
     * 获取关于股票的保证金数据。
     */
    public static final String CAPITAL_MARGIN_URL = "https://stock.xueqiu.com/v5/stock/capital/margin.json?symbol=";

    /**
     * 获取大宗交易数据。
     */
    public static final String CAPITAL_BLOCK_TRANS_URL = "https://stock.xueqiu.com/v5/stock/capital/blocktrans.json?symbol=";

    /**
     * 获取资本构成数据。
     */
    public static final String CAPITAL_ASSORT_URL = "https://stock.xueqiu.com/v5/stock/capital/assort.json?symbol=";

    /**
     * 获取资本历史数据。
     */
    public static final String CAPITAL_HISTORY_URL = "https://stock.xueqiu.com/v5/stock/capital/history.json?symbol=";

    /**
     * 获取资本流向数据。
     */
    public static final String CAPITAL_FLOW_URL = "https://stock.xueqiu.com/v5/stock/capital/flow.json?symbol=";


    private CapitalUrlConstant() {
    }
}
