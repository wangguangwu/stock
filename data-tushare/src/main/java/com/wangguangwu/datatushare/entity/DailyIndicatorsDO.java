package com.wangguangwu.datatushare.entity;

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
 * A股每日指标表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-04-26
 */
@Getter
@Setter
@TableName("daily_indicators")
public class DailyIndicatorsDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * TS股票代码
     */
    @TableField("ts_code")
    private String tsCode;

    /**
     * 交易日期
     */
    @TableField("trade_date")
    private LocalDate tradeDate;

    /**
     * 当日收盘价
     */
    @TableField("close")
    private BigDecimal close;

    /**
     * 换手率（%）
     */
    @TableField("turnover_rate")
    private BigDecimal turnoverRate;

    /**
     * 换手率（自由流通股）
     */
    @TableField("turnover_rate_f")
    private BigDecimal turnoverRateF;

    /**
     * 量比
     */
    @TableField("volume_ratio")
    private BigDecimal volumeRatio;

    /**
     * 市盈率（总市值/净利润，亏损的PE为空）
     */
    @TableField("pe")
    private BigDecimal pe;

    /**
     * 市盈率（TTM，亏损的PE为空）
     */
    @TableField("pe_ttm")
    private BigDecimal peTtm;

    /**
     * 市净率（总市值/净资产）
     */
    @TableField("pb")
    private BigDecimal pb;

    /**
     * 市销率
     */
    @TableField("ps")
    private BigDecimal ps;

    /**
     * 市销率（TTM）
     */
    @TableField("ps_ttm")
    private BigDecimal psTtm;

    /**
     * 股息率（%）
     */
    @TableField("dv_ratio")
    private BigDecimal dvRatio;

    /**
     * 股息率（TTM）（%）
     */
    @TableField("dv_ttm")
    private BigDecimal dvTtm;

    /**
     * 总股本（万股）
     */
    @TableField("total_share")
    private BigDecimal totalShare;

    /**
     * 流通股本（万股）
     */
    @TableField("float_share")
    private BigDecimal floatShare;

    /**
     * 自由流通股本（万）
     */
    @TableField("free_share")
    private BigDecimal freeShare;

    /**
     * 总市值（万元）
     */
    @TableField("total_mv")
    private BigDecimal totalMv;

    /**
     * 流通市值（万元）
     */
    @TableField("circ_mv")
    private BigDecimal circMv;

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
