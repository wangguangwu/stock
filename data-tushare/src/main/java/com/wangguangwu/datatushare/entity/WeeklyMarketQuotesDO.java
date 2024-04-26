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
 * A股周线行情
 * </p>
 *
 * @author wangguangwu
 * @since 2024-04-26
 */
@Getter
@Setter
@TableName("weekly_market_quotes")
public class WeeklyMarketQuotesDO implements Serializable {

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
     * 周开盘价
     */
    @TableField("open")
    private BigDecimal open;

    /**
     * 周最高价
     */
    @TableField("high")
    private BigDecimal high;

    /**
     * 周最低价
     */
    @TableField("low")
    private BigDecimal low;

    /**
     * 周收盘价
     */
    @TableField("close")
    private BigDecimal close;

    /**
     * 上一周收盘价
     */
    @TableField("pre_close")
    private BigDecimal preClose;

    /**
     * 周涨跌额
     */
    @TableField("ts_change")
    private BigDecimal tsChange;

    /**
     * 周涨跌幅（未复权）
     */
    @TableField("pct_chg")
    private BigDecimal pctChg;

    /**
     * 周成交量（手）
     */
    @TableField("vol")
    private BigDecimal vol;

    /**
     * 周成交额（千元）
     */
    @TableField("amount")
    private BigDecimal amount;

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
