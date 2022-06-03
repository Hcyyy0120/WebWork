package com.hcy.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hcy.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.pojo.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2022-06-01 10:33:30
* @Entity com.hcy.pojo.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    
    @Select("select t_product.id,t_product.item_type,t_product.title,t_product.sell_point,t_product.price," +
            "t_product.num,t_product.status,t_product.seller_name,t_product_category.type_name " +
            "from t_product,t_product_category " +
            "where t_product.category_id = t_product_category.id")
    List<ProductVo> getAllProductVo();
    
    List<ProductVo> selectAllByCondition(String title,String typeName,Long beginPrice,Long endPrice);
    
    @Select("select t_product.id,t_product.item_type,t_product.title,t_product.sell_point,t_product.price," +
            "t_product.num,t_product.status,t_product.seller_name,t_product_category.type_name " +
            "from t_product,t_product_category " +
            "where t_product.category_id = t_product_category.id and t_product.seller_name = #{sellerName}")
    List<ProductVo> selectAllBySeller(String sellerName);
}




