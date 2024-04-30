package com.wangguangwu.datasnowball.constant;

/**
 * 财务数据
 *
 * @author wangguangwu
 */
public final class FinanceUrlConstant {

    /**
     * 获取公司的现金流量表数据。
     */
    public static final String FINANCE_CASH_FLOW_URL = "https://stock.xueqiu.com/v5/stock/finance/cn/cash_flow.json?symbol=";

    /**
     * 获取公司的主要财务指标。
     */
    public static final String FINANCE_INDICATOR_URL = "https://stock.xueqiu.com/v5/stock/finance/cn/indicator.json?symbol=";

    /**
     * 获取公司的资产负债表数据。
     */
    public static final String FINANCE_BALANCE_URL = "https://stock.xueqiu.com/v5/stock/finance/cn/balance.json?symbol=";

    /**
     * 获取公司的利润表数据。
     */
    public static final String FINANCE_INCOME_URL = "https://stock.xueqiu.com/v5/stock/finance/cn/income.json?symbol=";

    /**
     * 获取公司的业务概览数据。
     */
    public static final String FINANCE_BUSINESS_URL = "https://stock.xueqiu.com/v5/stock/finance/cn/business.json?symbol=";

    private FinanceUrlConstant() {
    }
}
