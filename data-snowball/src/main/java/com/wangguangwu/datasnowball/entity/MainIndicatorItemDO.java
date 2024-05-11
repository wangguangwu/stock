package com.wangguangwu.datasnowball.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 财务信息详情表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-05-11
 */
@Getter
@Setter
@TableName("main_indicator_item")
public class MainIndicatorItemDO implements Serializable {

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
     * 资产负债比率
     */
    @TableField("asset_liab_ratio")
    private BigDecimal assetLiabRatio;

    /**
     * 抵押比率
     */
    @TableField("pledge_ratio")
    private BigDecimal pledgeRatio;

    /**
     * 净利润同比增长率
     */
    @TableField("net_profit_atsopc_yoy")
    private BigDecimal netProfitAtsopcYoy;

    /**
     * 营业收入同比增长率
     */
    @TableField("operating_income_yoy")
    private BigDecimal operatingIncomeYoy;

    /**
     * 净资产中的商誉
     */
    @TableField("goodwill_in_net_assets")
    private BigDecimal goodwillInNetAssets;

    /**
     * 基本每股收益
     */
    @TableField("basic_eps")
    private BigDecimal basicEps;

    /**
     * 净销售率
     */
    @TableField("net_selling_rate")
    private BigDecimal netSellingRate;

    /**
     * 平均股本回报率
     */
    @TableField("avg_roe")
    private BigDecimal avgRoe;

    /**
     * 毛销售率
     */
    @TableField("gross_selling_rate")
    private BigDecimal grossSellingRate;

    /**
     * 流通股份
     */
    @TableField("float_shares")
    private Long floatShares;

    /**
     * 市净率
     */
    @TableField("pb")
    private BigDecimal pb;

    /**
     * 每股净利润
     */
    @TableField("np_per_share")
    private BigDecimal npPerShare;

    /**
     * 流通市值
     */
    @TableField("float_market_capital")
    private BigDecimal floatMarketCapital;

    /**
     * 总收入
     */
    @TableField("total_revenue")
    private BigDecimal totalRevenue;

    /**
     * 市场资本
     */
    @TableField("market_capital")
    private BigDecimal marketCapital;

    /**
     * 滚动市盈率
     */
    @TableField("pe_ttm")
    private BigDecimal peTtm;

    /**
     * 股息
     */
    @TableField("dividend")
    private BigDecimal dividend;

    /**
     * 货币单位
     */
    @TableField("currency")
    private String currency;

    /**
     * 股息率
     */
    @TableField("dividend_yield")
    private BigDecimal dividendYield;

    /**
     * 净利润
     */
    @TableField("net_profit_atsopc")
    private BigDecimal netProfitAtsopc;

    /**
     * 总股份
     */
    @TableField("total_shares")
    private Long totalShares;

    /**
     * 报告日期
     */
    @TableField("report_date")
    private String reportDate;

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
