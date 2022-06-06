package com.hcy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderVo {
    private Integer oid;
    private Integer uid;
    private Integer pid;
    private String recvName;//收货人or用户名
    private String sellerName;//商家名
    private String title;//商品名or商品标题
    private Integer num;//订单中每种商品的数量
    private Long price;//订单中单个商品的总价格
    private Long totalPrice;//订单总价格
    private Integer state;//状态 0  1  2.....
    
}
