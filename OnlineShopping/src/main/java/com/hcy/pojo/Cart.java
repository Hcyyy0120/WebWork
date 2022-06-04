package com.hcy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_cart
 */
@TableName(value ="t_cart")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart implements Serializable {
    /**
     * 购物车数据id
     */
    @TableId(type = IdType.AUTO)
    private Integer cid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 加入时商品单价
     */
    private Long cartItemPrice;

    /**
     * 商品数量
     */
    private Integer cartItemNum;
    
    /**
     * 0：未提交
     * 1：提交订单，等待商家确认
     */
    private Integer cartItemState;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}