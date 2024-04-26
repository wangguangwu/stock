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
public class MarketQuotes {

    /**
     * 股票代码
     */
    private String tsCode;

    /**
     * 交易日期
     */
    private String tradeDate;

    /**
     * 开盘价
     */
    private String open;

    /**
     * 最高价
     */
    private String high;

    /**
     * 最低价
     */
    private String low;

    /**
     * 收盘价
     */
    private String close;

    /**
     * 昨收价（前复权）
     */
    private String preClose;

    /**
     * 涨跌额
     */
    private String change;

    /**
     * 涨跌幅（未复权）
     */
    private String pctChg;

    /**
     * 成交量（手）
     */
    private String vol;

    /**
     * 成交额（千元）
     */
    private String amount;

}
