package com.wangguangwu.datasnowball.constant;

/**
 * F10 数据
 *
 * @author wangguangwu
 */
public final class F10UrlConstant {

    /**
     * 获取公司股东变动信息。
     */
    public static final String F10_SKHOLDER_CHG = "https://stock.xueqiu.com/v5/stock/f10/cn/skholderchg.json?symbol=";

    /**
     * 获取公司股东信息。
     */
    public static final String F10_SKHOLDER = "https://stock.xueqiu.com/v5/stock/f10/cn/skholder.json?symbol=";

    /**
     * 获取行业信息。
     */
    public static final String F10_INDUSTRY = "https://stock.xueqiu.com/v5/stock/f10/cn/industry.json?symbol=";

    /**
     * 获取持股信息。
     */
    public static final String F10_HOLDERS = "https://stock.xueqiu.com/v5/stock/f10/cn/holders.json?&symbol=";

    /**
     * 获取公司分红信息。
     */
    public static final String F10_BONUS = "https://stock.xueqiu.com/v5/stock/f10/cn/bonus.json?&symbol=";

    /**
     * 获取机构持股变动信息。
     */
    public static final String F10_ORG_HOLDING_CHANGE = "https://stock.xueqiu.com/v5/stock/f10/cn/org_holding/change.json?symbol=";

    /**
     * 获取行业比较分析。
     */
    public static final String F10_INDUSTRY_COMPARE = "https://stock.xueqiu.com/v5/stock/f10/cn/industry/compare.json?type=single&symbol=";

    /**
     * 获取业务分析信息。
     */
    public static final String F10_BUSINESS_ANALYSIS = "https://stock.xueqiu.com/v5/stock/f10/cn/business_analysis.json?symbol=";

    /**
     * 获取股本变动信息。
     */
    public static final String F10_SHARESCHG = "https://stock.xueqiu.com/v5/stock/f10/cn/shareschg.json?symbol=";

    /**
     * 获取十大股东信息。
     */
    public static final String F10_TOP_HOLDERS = "https://stock.xueqiu.com/v5/stock/f10/cn/top_holders.json?&symbol=";

    /**
     * 获取财务指标信息。
     */
    public static final String F10_INDICATOR = "https://stock.xueqiu.com/v5/stock/f10/cn/indicator.json?symbol=";

    private F10UrlConstant() {
    }
}
