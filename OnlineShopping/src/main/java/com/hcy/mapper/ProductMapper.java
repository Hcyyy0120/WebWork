package com.hcy.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hcy.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hcy.pojo.vo.ProductVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2022-06-01 10:33:30
* @Entity com.hcy.pojo.Product
*/
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 查询所有商品
     * @return
     */
    @Select("select t_product.id,t_product.item_type,t_product.title,t_product.sell_point,t_product.price," +
            "t_product.num,t_product.status,t_product.seller_name,t_product_category.type_name " +
            "from t_product,t_product_category " +
            "where t_product.category_id = t_product_category.id and t_product.status = 1")
    List<ProductVo> getAllProductVo();
    
    /**
     * 多条件查询商品
     * @param title
     * @param typeName
     * @param beginPrice
     * @param endPrice
     * @param sellerName
     * @return
     */
    List<ProductVo> selectAllByCondition(String title,String typeName,Long beginPrice,Long endPrice,String sellerName);
    
    /**
     * 商家查询自身所拥有商品
     * @param sellerName
     * @return
     */
    @Select("select t_product.id,t_product.item_type,t_product.title,t_product.sell_point,t_product.price," +
            "t_product.num,t_product.status,t_product.seller_name,t_product_category.type_name " +
            "from t_product,t_product_category " +
            "where t_product.category_id = t_product_category.id and t_product.seller_name = #{sellerName} and t_product.status = 1")
    List<ProductVo> selectAllProductVoBySeller(String sellerName);
    
    /**
     * 商家删除商品
     */
    @Update("update t_product set status = 0 where id = #{id}")
    void deleteProductById(Integer id);
    
    /**
     *商家新增商品
     */
    @Insert("INSERT INTO t_product(category_id,item_type,title,sell_point,price,num,seller_name) " +
            "VALUES(#{categoryId},#{itemType},#{title},#{sellPoint},#{price},#{num},#{sellerName})")
    void insertProduct(ProductVo productVo);
    
    /**
     * 商家修改商品
     * @param productVo
     */
    @Update("update t_product set category_id = #{categoryId},item_type = #{itemType}," +
            "title = #{title},sell_point = #{sellPoint},price = #{price},num = #{num} where id = #{id}")
    void updateProductById(ProductVo productVo);
    
}




