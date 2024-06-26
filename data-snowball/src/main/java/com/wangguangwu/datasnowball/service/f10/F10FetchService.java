package com.wangguangwu.datasnowball.service.f10;

import com.wangguangwu.datasnowball.constant.F10UrlConstant;

/**
 * 获取 F10 数据 - 基本面资料
 * {@link  F10UrlConstant}  F10 数据 url
 *
 * @author wangguangwu
 */
public interface F10FetchService {

    /**
     * 获取公司股东变动信息。
     *
     * @param symbol 股票代码
     * @return 公司股东变动信息
     */
    String skHolderChgFetch(String symbol);

    /**
     * 获取公司股东信息。
     *
     * @param symbol 股票代码
     * @return 公司股东信息
     */
    String skHolderFetch(String symbol);

    /**
     * 获取行业信息。
     *
     * @param symbol 股票代码
     * @return 行业信息
     */
    String industryFetch(String symbol);

    /**
     * 获取持股信息。
     *
     * @param symbol 股票代码
     * @return 持股信息
     */
    String holdersFetch(String symbol);

    /**
     * 获取公司分红信息。
     *
     * @param symbol 股票代码
     * @param page   分页起始
     * @param size   分页数量
     * @return 公司分红信息
     */
    String bonusFetch(String symbol, int page, int size);

    /**
     * 获取机构持股变动信息。
     *
     * @param symbol 股票代码
     * @return 机构持股变动信息
     */
    String orgHoldingChangeFetch(String symbol);

    /**
     * 获取行业比较分析。
     *
     * @param symbol 股票代码
     * @return 行业比较分析
     */
    String industryCompareFetch(String symbol);

    /**
     * 获取业务分析信息。
     *
     * @param symbol 股票代码
     * @return 业务分析信息
     */
    String businessAnalysisFetch(String symbol);

    /**
     * 获取股本变动信息。
     *
     * @param symbol 股票代码
     * @param count  获取数量
     * @return 股本变动信息
     */
    String sharesChgFetch(String symbol, int count);

    /**
     * 获取十大股东信息。
     *
     * @param symbol  股票代码
     * @param circula 循环次数
     * @return 十大股东信息
     */
    String topHoldersFetch(String symbol, int circula);

    /**
     * 获取财务指标信息。
     *
     * @param symbol 股票代码
     * @return 财务指标信息
     */
    String mainIndicatorFetch(String symbol);

}
