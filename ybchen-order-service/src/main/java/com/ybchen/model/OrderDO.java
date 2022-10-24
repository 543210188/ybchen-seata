package com.ybchen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author chenyanbin
 * @since 2022-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("o_order")
@ApiModel(value = "OrderDO对象", description = "订单表")
public class OrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String outTradeNo;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
