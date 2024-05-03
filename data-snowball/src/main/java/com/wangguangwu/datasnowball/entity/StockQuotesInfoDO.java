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
 * 股票行情信息表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-05-03
 */
@Getter
@Setter
@TableName("stock_quotes_info")
public class StockQuotesInfoDO implements Serializable {

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
     * 交易日期
     */
    @TableField("trade_date")
    private LocalDate tradeDate;

    /**
     * 成交量，指在某段时间内交易的股票数量
     */
    @TableField("volume")
    private Long volume;

    /**
     * 开盘价，指某一交易日开始时的股票价格
     */
    @TableField("open")
    private BigDecimal open;

    /**
     * 最高价，某一交易日中股票达到的最高价格
     */
    @TableField("high")
    private BigDecimal high;

    /**
     * 最低价，某一交易日中股票达到的最低价格
     */
    @TableField("low")
    private BigDecimal low;

    /**
     * 收盘价，指某一交易日结束时的股票价格
     */
    @TableField("close")
    private BigDecimal close;

    /**
     * 变动值，通常指从前一个交易日的收盘价到当前收盘价的变化
     */
    @TableField("chg")
    private BigDecimal chg;

    /**
     * 百分比，通常指股票价格的变化率
     */
    @TableField("percent")
    private BigDecimal percent;

    /**
     * 换手率，表示在一定时间内股票换手的频率
     */
    @TableField("turnover_rate")
    private BigDecimal turnoverRate;

    /**
     * 成交金额，指在某段时间内股票交易的总金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 盘后成交量，指在正常交易时段之外的成交量
     */
    @TableField("volume_post")
    private Long volumePost;

    /**
     * 盘后成交金额，指在正常交易时段之外的成交金额
     */
    @TableField("amount_post")
    private BigDecimal amountPost;

    /**
     * 市盈率，反映股票价格与每股收益的比率
     */
    @TableField("pe")
    private BigDecimal pe;

    /**
     * 市净率，股票市价与每股净资产的比率
     */
    @TableField("pb")
    private BigDecimal pb;

    /**
     * 市销率，市场资本总额与销售收入的比率
     */
    @TableField("ps")
    private BigDecimal ps;

    /**
     * 市现率，市值与现金流的比率
     */
    @TableField("pcf")
    private BigDecimal pcf;

    /**
     * 市值，公司股票总额乘以其股票价格
     */
    @TableField("market_capital")
    private BigDecimal marketCapital;

    /**
     * 结算价，指某一特定时间段内的结算价格
     */
    @TableField("balance")
    private BigDecimal balance;

    /**
     * 中国持股量，可能指某股票在中国的持有量
     */
    @TableField("hold_volume_cn")
    private Long holdVolumeCn;

    /**
     * 中国持股比例，可能指某股票在中国持有量的比例
     */
    @TableField("hold_ratio_cn")
    private BigDecimal holdRatioCn;

    /**
     * 中国净持股量，指中国持股量的净变化
     */
    @TableField("net_volume_cn")
    private Long netVolumeCn;

    /**
     * 香港持股量，指某股票在香港的持有量
     */
    @TableField("hold_volume_hk")
    private Long holdVolumeHk;

    /**
     * 香港持股比例，指某股票在香港持有量的比例
     */
    @TableField("hold_ratio_hk")
    private BigDecimal holdRatioHk;

    /**
     * 香港净持股量，指香港持股量的净变化
     */
    @TableField("net_volume_hk")
    private Long netVolumeHk;

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
