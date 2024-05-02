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
 * 前十大股东退出表
 * </p>
 *
 * @author wangguangwu
 * @since 2024-05-02
 */
@Getter
@Setter
@TableName("top_holders_quit")
public class TopHoldersQuitDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 关联top_holders_summary表的id
     */
    @TableField("summary_id")
    private Integer summaryId;

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
     * 持股排名
     */
    @TableField("holder_rank")
    private Integer holderRank;

    /**
     * 持股机构名称
     */
    @TableField("holder_name")
    private String holderName;

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
