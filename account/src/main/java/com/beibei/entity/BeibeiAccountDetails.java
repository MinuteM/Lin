package com.beibei.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 账单明细
 * </p>
 *
 * @author linxy
 * @since 2021-08-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BeibeiAccountDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 收支类型，0-收，1-支
     */
    private Integer iEType;

    /**
     * 收支小类
     */
    private Integer iESubcategory;

    /**
     * 账户from
     */
    private Long fromAccount;

    /**
     * 账户to
     */
    private Long toAccount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账期
     */
    private String billingPeriod;


}
