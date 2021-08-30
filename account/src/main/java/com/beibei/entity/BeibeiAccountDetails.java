package com.beibei.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 账期
     */
    private String billingPeriod;


}
