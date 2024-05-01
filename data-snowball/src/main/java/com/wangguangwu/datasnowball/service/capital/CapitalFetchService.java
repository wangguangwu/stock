package com.wangguangwu.datasnowball.service.capital;

import com.wangguangwu.datasnowball.constant.CapitalUrlConstant;

/**
 * 获取资本市场数据接口
 * <p>
 * {@link CapitalUrlConstant} 资本市场数据 url
 *
 * @author wangguangwu
 */
public interface CapitalFetchService {

    /**
     * 获取股票的保证金数据。
     *
     * @param symbol 股票代码
     * @param page   分页数
     * @param size   每页容量
     * @return 股票的保证金数据
     */
    String margin(String symbol, int page, int size);

    /**
     * 获取大宗交易数据。
     *
     * @param symbol 股票代码
     * @param page   分页数
     * @param size   每页容量
     * @return 大宗交易数据
     */
    String blockTrans(String symbol, int page, int size);


    /**
     * 获取资本构成数据。
     *
     * @param symbol 股票代码
     * @return 资本构成数据
     */
    String assort(String symbol);

    /**
     * 获取资本流向数据。
     *
     * @param symbol 股票代码
     * @return 资本流向数据
     */
    String flow(String symbol);

    /**
     * 获取资本历史数据。
     *
     * @param symbol 股票代码
     * @param count  返回数据的数量
     * @return 资本历史数据
     */
    String history(String symbol, int count);

}
