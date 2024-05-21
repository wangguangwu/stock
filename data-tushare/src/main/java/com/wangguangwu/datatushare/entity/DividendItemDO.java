package com.wangguangwu.datatushare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 分红送股数据详情表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-05-20
 */
@Getter
@Setter
@TableName("dividend_item")
public class DividendItemDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 股票代码
     */
    @TableField("ts_code")
    private String tsCode;

    /**
     * 股票名称
     */
    @TableField("ts_name")
    private String tsName;

    /**
     * 分红年度
     */
    @TableField("end_date")
    private String endDate;

    /**
     * 预案公告日
     */
    @TableField("ann_date")
    private String annDate;

    /**
     * 实施进度
     */
    @TableField("div_proc")
    private String divProc;

    /**
     * 每股送转
     */
    @TableField("stk_div")
    private Double stkDiv;

    /**
     * 每股送股比例
     */
    @TableField("stk_bo_rate")
    private Double stkBoRate;

    /**
     * 每股转增比例
     */
    @TableField("stk_co_rate")
    private Double stkCoRate;

    /**
     * 每股分红（税后）
     */
    @TableField("cash_div")
    private Double cashDiv;

    /**
     * 每股分红（税前）
     */
    @TableField("cash_div_tax")
    private Double cashDivTax;

    /**
     * 股权登记日
     */
    @TableField("record_date")
    private String recordDate;

    /**
     * 除权除息日
     */
    @TableField("ex_date")
    private String exDate;

    /**
     * 派息日
     */
    @TableField("pay_date")
    private String payDate;

    /**
     * 红股上市日
     */
    @TableField("div_list_date")
    private String divListDate;

    /**
     * 实施公告日
     */
    @TableField("imp_ann_date")
    private String impAnnDate;

    /**
     * 基准日
     */
    @TableField("base_date")
    private String baseDate;

    /**
     * 基准股本（万）
     */
    @TableField("base_share")
    private Double baseShare;

    /**
     * 删除标志位。0: 未删除，1: 已删除
     */
    @TableField("is_deleted")
    @TableLogic
    private Boolean isDeleted;

    /**
     * 版本号
     */
    @TableField("version")
    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField("gmt_create")
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField("gmt_updated")
    private LocalDateTime gmtUpdated;
}
