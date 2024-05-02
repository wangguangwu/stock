package com.wangguangwu.datasnowball.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 前十大股东汇总表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-05-02
 */
@Getter
@Setter
@TableName("top_holders_summary")
public class TopHoldersSummaryDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 股票代码
     */
    @TableField("symbol")
    private String symbol;

    /**
     * 报告名称
     */
    @TableField("report_name")
    private String reportName;

    /**
     * 报告日期
     */
    @TableField("report_date")
    private LocalDate reportDate;

    /**
     * 变化率，表示从前一个报告期到当前报告期的持股变化百分比
     */
    @TableField("chg")
    private BigDecimal chg;

    /**
     * 持有的股份数量
     */
    @TableField("held_num")
    private Long heldNum;

    /**
     * 持股比例
     */
    @TableField("held_ratio")
    private BigDecimal heldRatio;

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
