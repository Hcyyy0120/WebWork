package com.hcy.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Integer oid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 收货人姓名
     */
    private String recvName;

    /**
     * 总价
     */
    private Long totalPrice;

    /**
     * 状态：0-未支付，1-已支付，2-已完成
     */
    private Integer status;
    
    @TableLogic//逻辑删除
    private Integer isDeleted;
    
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}