package com.hcy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_product_category
 */
@TableName(value ="t_product_category")
@Data
public class ProductCategory implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 类别名称
     */
    private String typeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}