package com.wangguangwu.datasnowball.service.finance;

import com.wangguangwu.datasnowball.constant.FinanceUrlConstant;

/**
 * 获取财务数据接口
 * <p>
 * {@link FinanceUrlConstant} 财务数据 url
 *
 * @author wangguangwu
 */
public interface FinanceFetchService {

    /**
     * 获取指定公司的现金流量数据。
     *
     * @param symbol   股票代码
     * @param isAnnals 是否仅获取年度数据，1为是，0为否
     * @param count    返回数据的数量
     * @return 现金流量数据
     */
    String caseFlow(String symbol, int isAnnals, int count);

    /**
     * 获取公司的主要财务指标。
     *
     * @param symbol   股票代码
     * @param isAnnals 是否仅获取年度数据，1为是，0为否
     * @param count    返回数据的数量
     * @return 公司的主要财务指标数据
     */
    String indicator(String symbol, int isAnnals, int count);

    /**
     * 获取公司的资产负债表数据。
     *
     * @param symbol   股票代码
     * @param isAnnals 是否仅获取年度数据，1为是，0为否
     * @param count    返回数据的数量
     * @return 公司的资产负债表数据
     */
    String balance(String symbol, int isAnnals, int count);

    /**
     * 获取公司的利润表数据。
     *
     * @param symbol   股票代码
     * @param isAnnals 是否仅获取年度数据，1为是，0为否
     * @param count    返回数据的数量
     * @return 公司的利润表数据
     */
    String income(String symbol, int isAnnals, int count);

    /**
     * 获取公司的业务概览数据。
     *
     * @param symbol   股票代码
     * @param isAnnals 是否仅获取年度数据，1为是，0为否
     * @param count    返回数据的数量
     * @return 公司的业务概览数据
     */
    String business(String symbol, int isAnnals, int count);

}
