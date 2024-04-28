package com.wangguangwu.datatushare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyIndicators {

    /**
     * TS股票代码
     */
    private String tsCode;

    /**
     * 交易日期
     */
    private String tradeDate;

    /**
     * 当日收盘价
     */
    private String close;

    /**
     * 换手率（%）
     */
    private String turnoverRate;

    /**
     * 换手率（自由流通股）
     */
    private String turnoverRateF;

    /**
     * 量比
     */
    private String volumeRatio;

    /**
     * 市盈率（总市值/净利润，亏损的PE为空）
     */
    private String pe;

    /**
     * 市盈率（TTM，亏损的PE为空）
     */
    private String peTtm;

    /**
     * 市净率（总市值/净资产）
     */
    private String pb;

    /**
     * 市销率
     */
    private String ps;

    /**
     * 市销率（TTM）
     */
    private String psTtm;

    /**
     * 股息率（%）
     */
    private String dvRatio;

    /**
     * 股息率（TTM）（%）
     */
    private String dvTtm;

    /**
     * 总股本（万股）
     */
    private String totalShare;

    /**
     * 流通股本（万股）
     */
    private String floatShare;

    /**
     * 自由流通股本（万）
     */
    private String freeShare;

    /**
     * 总市值（万元）
     */
    private String totalMv;

    /**
     * 流通市值（万元）
     */
    private String circMv;

}
