package com.hcy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartVo {
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long cartItemPrice;
    private Integer cartItemNum;
    /**
     * 0：未提交
     * 1：提交订单，等待商家确认
     */
    private Integer cartItemState;
    private String title;
    //private Long cartItemTotalPrice;
}
