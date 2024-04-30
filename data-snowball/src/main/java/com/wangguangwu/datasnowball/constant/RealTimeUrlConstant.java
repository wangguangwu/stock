package com.wangguangwu.datasnowball.constant;

/**
 * 实时数据
 *
 * @author wangguangwu
 */
public final class RealTimeUrlConstant {

    /**
     * 获取实时股票报价。
     */
    public static final String REALTIME_QUOTE = "https://stock.xueqiu.com/v5/stock/realtime/quotec.json?symbol=";

    /**
     * 获取股票的买卖盘口数据。
     */
    public static final String REALTIME_PAN_KOU = "https://stock.xueqiu.com/v5/stock/realtime/pankou.json?symbol=";

    /**
     * 获取股票详细的实时数据。
     */
    public static final String REALTIME_QUOTE_DETAIL = "https://stock.xueqiu.com/v5/stock/quote.json?extend=detail&symbol=";


    private RealTimeUrlConstant() {
    }
}
