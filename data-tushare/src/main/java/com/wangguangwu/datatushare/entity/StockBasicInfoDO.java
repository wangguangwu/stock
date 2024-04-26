package com.wangguangwu.datatushare.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 股票基础信息详情表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-04-17
 */
@Data
@TableName("stock_basic_info")
public class StockBasicInfoDO {

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
