package com.wangguangwu.datasnowball.constant;

/**
 * 基金数据
 *
 * @author wangguangwu
 */
public final class FundUrlConstant {

    /**
     * 获取基金的详细信息。
     */
    public static final String FUND_DETAIL = "https://danjuanapp.com/djapi/fund/detail/%s";

    /**
     * 获取基金的基本信息。
     */
    public static final String FUND_INFO = "https://danjuanapp.com/djapi/fund/%s";

    /**
     * 获取基金的增长情况，需要基金代码和时间参数。
     */
    public static final String FUND_GROWTH = "https://danjuanapp.com/djapi/fund/growth/%s?day=%s";

    /**
     * 获取基金的历史净值，需要基金代码、页码和页大小参数。
     */
    public static final String FUND_NAV_HISTORY = "https://danjuanapp.com/djapi/fund/nav/history/%s?page=%s&size=%s";

    /**
     * 获取基金的成就信息。
     */
    public static final String FUND_ACHIEVEMENT = "https://danjuanapp.com/djapi/fundx/base/fund/achievement/%s";

    /**
     * 获取基金的持仓百分比信息。
     */
    public static final String FUND_ASSET = "https://danjuanapp.com/djapi/fundx/base/fund/record/asset/percent?fund_code=%s";

    /**
     * 获取基金管理人的列表，需要基金代码和职位状态参数。
     */
    public static final String FUND_MANAGER = "https://danjuanapp.com/djapi/fundx/base/fund/record/manager/list?fund_code=%s&post_status=%s";

    /**
     * 获取基金的交易日期信息。
     */
    public static final String FUND_TRADE_DATE = "https://danjuanapp.com/djapi/fund/order/v2/trade_date?fd_code=%s";

    /**
     * 获取基金的派生数据。
     */
    public static final String FUND_DERIVED = "https://danjuanapp.com/djapi/fund/derived/%s";

    private FundUrlConstant() {
    }
}
