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
 * 商品库存
 * </p>
 *
 * @author chenyanbin
 * @since 2022-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("p_product_stock")
@ApiModel(value = "PProductStockDO对象", description = "商品库存")
public class ProductStockDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "购买数量")
    private Integer buyNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
