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
public class StockInfo {

    /**
     * 股票代码
     */
    private String tsCode;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 地区
     */
    private String area;

    /**
     * 行业
     */
    private String industry;

    /**
     * 市场类别（例如：主板、创业板、科创板等）
     */
    private String market;

    /**
     * 上市日期
     */
    private String listDate;

}
