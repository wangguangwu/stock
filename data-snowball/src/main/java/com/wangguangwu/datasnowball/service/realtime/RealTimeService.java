package com.wangguangwu.datasnowball.service.realtime;

/**
 * @author wangguangwu
 */
public interface RealTimeService {

    /**
     * 获取股票的 K 线图。
     *
     * @param symbol 股票代码
     * @param days   时间周期
     * @return 获取是否成功
     */
    boolean kline(String symbol, int days);

}
