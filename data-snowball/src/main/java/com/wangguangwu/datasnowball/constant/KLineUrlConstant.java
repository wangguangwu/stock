package com.wangguangwu.datasnowball.constant;

/**
 * K 线图
 *
 * @author wangguangwu
 */
public final class KLineUrlConstant {

    /**
     * 获取股票的 K 线图，支持不同的时间周期。
     */
    public static final String KLINE = "https://stock.xueqiu.com/v5/stock/chart/kline.json?symbol={}&begin={}&period=day&type=before&count=-{}&indicator=kline,pe,pb,ps,pcf,market_capital,agt,ggt,balance";


    private KLineUrlConstant() {
    }
}
