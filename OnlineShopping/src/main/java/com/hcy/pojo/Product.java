package com.hcy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_product
 */
@TableName(value ="t_product")
@Data
public class Product implements Serializable {
    /**
     * 商品id
     */
    @TableId
    private Integer id;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 商品系列
     */
    private String itemType;

    /**
     * 商品标题
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
     * 商品状态  1：上架   0：删除
     */
    private Integer status;

    /**
     * 商家
     */
    private String sellerName;
    
    @TableField(exist = false)
    private ProductCategory productCategory;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}