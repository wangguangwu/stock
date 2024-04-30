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
 * 现金流量数据分析报告表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-04-29
 */
@Getter
@Setter
@TableName("case_flow_finance_report")
public class CaseFlowFinanceReportDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 股票名称
     */
    @TableField("quote_name")
    private String quoteName;

    /**
     * 报告日期
     */
    @TableField("report_date")
    private LocalDate reportDate;

    /**
     * 报告名称
     */
    @TableField("report_name")
    private String reportName;

    /**
     * 经营活动产生的现金流量净额
     */
    @TableField("ncf_from_oa_value")
    private BigDecimal ncfFromOaValue;

    /**
     * 经营活动产生的现金流量净额变化率
     */
    @TableField("ncf_from_oa_rate")
    private BigDecimal ncfFromOaRate;

    /**
     * 投资活动产生的现金流量净额
     */
    @TableField("ncf_from_ia_value")
    private BigDecimal ncfFromIaValue;

    /**
     * 投资活动产生的现金流量净额变化率
     */
    @TableField("ncf_from_ia_rate")
    private BigDecimal ncfFromIaRate;

    /**
     * 筹资活动产生的现金流量净额
     */
    @TableField("ncf_from_fa_value")
    private BigDecimal ncfFromFaValue;

    /**
     * 筹资活动产生的现金流量净额变化率
     */
    @TableField("ncf_from_fa_rate")
    private BigDecimal ncfFromFaRate;

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
