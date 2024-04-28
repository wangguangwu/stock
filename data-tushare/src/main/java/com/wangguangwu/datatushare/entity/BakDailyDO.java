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
 * A股备用详情表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-04-28
 */
@Getter
@Setter
@TableName("bak_daily")
public class BakDailyDO implements Serializable {

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
     * 交易日期
     */
    @TableField("trade_date")
    private LocalDate tradeDate;

    /**
     * 股票名称
     */
    @TableField("name")
    private String name;

    /**
     * 涨跌幅
     */
    @TableField("pct_change")
    private BigDecimal pctChange;

    /**
     * 收盘价
     */
    @TableField("close")
    private BigDecimal close;

    /**
     * 涨跌额
     */
    @TableField("ts_change")
    private BigDecimal tsChange;

    /**
     * 开盘价
     */
    @TableField("open")
    private BigDecimal open;

    /**
     * 最高价
     */
    @TableField("high")
    private BigDecimal high;

    /**
     * 最低价
     */
    @TableField("low")
    private BigDecimal low;

    /**
     * 昨收价
     */
    @TableField("pre_close")
    private BigDecimal preClose;

    /**
     * 量比
     */
    @TableField("vol_ratio")
    private BigDecimal volRatio;

    /**
     * 换手率
     */
    @TableField("turn_over")
    private BigDecimal turnOver;

    /**
     * 振幅
     */
    @TableField("swing")
    private BigDecimal swing;

    /**
     * 成交量
     */
    @TableField("vol")
    private BigDecimal vol;

    /**
     * 成交额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 内盘（主动卖，手）
     */
    @TableField("selling")
    private BigDecimal selling;

    /**
     * 外盘（主动买，手）
     */
    @TableField("buying")
    private BigDecimal buying;

    /**
     * 总股本(亿)
     */
    @TableField("total_share")
    private BigDecimal totalShare;

    /**
     * 流通股本(亿)
     */
    @TableField("float_share")
    private BigDecimal floatShare;

    /**
     * 市盈(动)
     */
    @TableField("pe")
    private BigDecimal pe;

    /**
     * 所属行业
     */
    @TableField("industry")
    private String industry;

    /**
     * 所属地域
     */
    @TableField("area")
    private String area;

    /**
     * 流通市值
     */
    @TableField("float_mv")
    private BigDecimal floatMv;

    /**
     * 总市值
     */
    @TableField("total_mv")
    private BigDecimal totalMv;

    /**
     * 平均价
     */
    @TableField("avg_price")
    private BigDecimal avgPrice;

    /**
     * 强弱度(%)
     */
    @TableField("strength")
    private BigDecimal strength;

    /**
     * 活跃度(%)
     */
    @TableField("activity")
    private BigDecimal activity;

    /**
     * 笔换手
     */
    @TableField("avg_turnover")
    private BigDecimal avgTurnover;

    /**
     * 攻击波(%)
     */
    @TableField("attack")
    private BigDecimal attack;

    /**
     * 近3月涨幅
     */
    @TableField("interval_3")
    private BigDecimal interval3;

    /**
     * 近6月涨幅
     */
    @TableField("interval_6")
    private BigDecimal interval6;

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
