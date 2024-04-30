package com.wangguangwu.datasnowball.constant;

/**
 * 东方财富数据
 *
 * @author wangguangwu
 */
public final class EastMoneyUrlConstant {

    /**
     * 获取可转债的数据。
     */
    public static final String CONVERTIBLE_BOND = "https://datacenter-web.eastmoney.com/api/data/v1/get?pageSize={}&pageNumber={}&sortColumns=PUBLIC_START_DATE&sortTypes=-1&reportName=RPT_BOND_CB_LIST&columns=ALL&quoteColumns=f2~01~CONVERT_STOCK_CODE~CONVERT_STOCK_PRICE%2Cf235~10~SECURITY_CODE~TRANSFER_PRICE%2Cf236~10~SECURITY_CODE~TRANSFER_VALUE%2Cf2~10~SECURITY_CODE~CURRENT_BOND_PRICE%2Cf237~10~SECURITY_CODE~TRANSFER_PREMIUM_RATIO%2Cf239~10~SECURITY_CODE~RESALE_TRIG_PRICE%2Cf240~10~SECURITY_CODE~REDEEM_TRIG_PRICE%2Cf23~01~CONVERT_STOCK_CODE~PBV_RATIO&source=WEB&client=WEB";


    private EastMoneyUrlConstant() {
    }
}
