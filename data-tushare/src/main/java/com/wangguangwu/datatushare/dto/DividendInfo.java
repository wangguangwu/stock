package com.wangguangwu.datatushare.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * @author wangguangwu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DividendInfo {

    /**
     * TS代码
     */
    private String tsCode;

    /**
     * 分红年度
     */
    private String endDate;

    /**
     * 预案公告日
     */
    private String annDate;

    /**
     * 实施进度
     */
    private String divProc;

    /**
     * 每股送转
     */
    private Float stkDiv;

    /**
     * 每股送股比例
     */
    private Float stkBoRate;

    /**
     * 每股转增比例
     */
    private Float stkCoRate;

    /**
     * 每股分红（税后）
     */
    private Float cashDiv;

    /**
     * 每股分红（税前）
     */
    private Float cashDivTax;

    /**
     * 股权登记日
     */
    private String recordDate;

    /**
     * 除权除息日
     */
    private String exDate;

    /**
     * 派息日
     */
    private String payDate;

    /**
     * 红股上市日
     */
    private String divListdate;

    /**
     * 实施公告日
     */
    private String impAnnDate;

    /**
     * 基准日（可选）
     */
    private String baseDate;

    /**
     * 基准股本（万）（可选）
     */
    private Float baseShare;
}
