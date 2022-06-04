package com.hcy.mapper;

import com.hcy.pojo.ProductCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 16691
* @description 针对表【t_product_category】的数据库操作Mapper
* @createDate 2022-06-01 11:33:11
* @Entity com.hcy.pojo.ProductCategory
*/
@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {

}




