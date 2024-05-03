package com.wangguangwu.datasnowball.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 股票基础信息详情表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-05-03
 */
@Getter
@Setter
@TableName("stock_basic_info")
public class StockBasicInfoDO implements Serializable {

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
     * 股票名称
     */
    @TableField("name")
    private String name;

    /**
     * 地区
     */
    @TableField("area")
    private String area;

    /**
     * 行业
     */
    @TableField("industry")
    private String industry;

    /**
     * 市场类别（例如：主板、创业板、科创板等）
     */
    @TableField("market")
    private String market;

    /**
     * 上市日期
     */
    @TableField("list_date")
    private LocalDate listDate;

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
