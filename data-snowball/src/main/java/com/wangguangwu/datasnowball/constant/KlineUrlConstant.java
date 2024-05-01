package com.wangguangwu.datasnowball.constant;

/**
 * K 线图 url。
 *
 * @author wangguangwu
 */
public final class KlineUrlConstant {

    /**
     * 获取股票的 K 线图，支持不同的时间周期。
     */
    public static final String KLINE = "https://stock.xueqiu.com/v5/stock/chart/kline.json?symbol=%s&begin=%d&period=day&type=before&count=-%d&indicator=kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance";

    private KlineUrlConstant() {
    }
}
