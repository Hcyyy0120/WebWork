package com.hcy.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductVo {
    
    /**
     * 商品id（pid）
     */
    private Integer id;
    
    private Integer categoryId;
    /**
     * 类型名称
     */
    private String typeName;
    
    /**
     * 商品系列
     */
    private String itemType;
    
    /**
     * 商品标题/名
     */
    private String title;
    
    /**
     * 商品卖点
     */
    private String sellPoint;
    
    /**
     * 商品单价
     */
    private Long price;
    
    /**
     * 库存数量
     */
    private Integer num;
    
    /**
     * 商品状态  1：上架   2：下架   3：删除
     */
    //private Integer status;
    
    private Long beginPrice;
    private Long endPrice;
    
    /**
     * 商家名
     */
    private String sellerName;

}
