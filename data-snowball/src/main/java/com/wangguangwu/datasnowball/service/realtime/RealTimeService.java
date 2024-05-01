package com.wangguangwu.datasnowball.service.realtime;

import com.wangguangwu.datasnowball.constant.KlineUrlConstant;
import com.wangguangwu.datasnowball.constant.RealTimeUrlConstant;

/**
 * 获取实时数据接口
 * <p>
 * {@link RealTimeUrlConstant} 实时数据 url
 * {@link KlineUrlConstant}  k 线图 url
 *
 * @author wangguangwu
 */
public interface RealTimeService {

    /**
     * 获取实时股票报价。
     *
     * @param symbol 股票代码
     * @return 实时股票报价
     */
    String quoteC(String symbol);

    /**
     * 获取股票的买卖盘口数据。
     *
     * @param symbol 股票代码
     * @return 股票的买卖盘口数据
     */
    String quoteDetail(String symbol);

    /**
     * 获取股票详细的实时数据。
     *
     * @param symbol 股票代码
     * @return 股票详细的实时数据
     */
    String panKou(String symbol);

    /**
     * 获取股票的 K 线图。
     *
     * @param symbol 股票代码
     * @param days   时间周期
     * @return K 线图
     */
    String kline(String symbol, int days);

}
