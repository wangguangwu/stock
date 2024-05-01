package com.wangguangwu.datasnowball.service.f10;

/**
 * @author wangguangwu
 */
public interface F10Service {

    /**
     * 获取公司股东变动信息。
     *
     * @param symbol 股票代码
     * @return 公司股东变动信息
     */
    String skHolderChg(String symbol);

    /**
     * 获取公司股东信息。
     *
     * @param symbol 股票代码
     * @return 公司股东信息
     */
    String skHolder(String symbol);

    /**
     * 获取行业信息。
     *
     * @param symbol 股票代码
     * @return 行业信息
     */
    String industry(String symbol);

    /**
     * 获取持股信息。
     *
     * @param symbol 股票代码
     * @return 持股信息
     */
    String holders(String symbol);

    /**
     * 获取公司分红信息。
     *
     * @param symbol 股票代码
     * @param page   分页起始
     * @param size   分页数量
     * @return 公司分红信息
     */
    String bonus(String symbol, int page, int size);

    /**
     * 获取机构持股变动信息。
     *
     * @param symbol 股票代码
     * @return 机构持股变动信息
     */
    String orgHoldingChange(String symbol);

    /**
     * 获取行业比较分析。
     *
     * @param symbol 股票代码
     * @return 行业比较分析
     */
    String industryCompare(String symbol);

    /**
     * 获取业务分析信息。
     *
     * @param symbol 股票代码
     * @return 业务分析信息
     */
    String businessAnalysis(String symbol);

    /**
     * 获取股本变动信息。
     *
     * @param symbol 股票代码
     * @param count  获取数量
     * @return 股本变动信息
     */
    String sharesChg(String symbol, int count);

    /**
     * 获取十大股东信息。
     *
     * @param symbol  股票代码
     * @param circula 循环次数
     * @return 十大股东信息
     */
    String topHolders(String symbol, int circula);

    /**
     * 获取财务指标信息。
     *
     * @param symbol 股票代码
     * @return 财务指标信息
     */
    String mainIndicator(String symbol);

}
