package com.hcy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_order_item
 */
@TableName(value ="t_order_item")
@Data
public class OrderItem implements Serializable {
    /**
     * 订单中的商品记录的id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 所归属的订单的id
     */
    private Integer oid;

    /**
     * 商品的id
     */
    private Integer pid;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品价格
     */
    private Long price;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 0：商家未确认     1：商家已确认
     */
    private Integer state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}