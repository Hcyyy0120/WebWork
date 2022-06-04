package com.hcy.service;

import com.hcy.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.pojo.vo.ProductVo;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_product】的数据库操作Service
* @createDate 2022-06-03 12:13:17
*/
public interface ProductService extends IService<Product> {
    
    List<ProductVo> getAllProductVo(ProductVo productVo);
    
    List<ProductVo> selectAllByCondition(String title,String typeName,Long beginPrice,Long endPrice,String sellerName);
    
    List<ProductVo> selectAllProductVoBySeller(String sellerName);
    
    void deleteProductById(ProductVo productVo);
    
    void insertProduct(ProductVo productVo);
    
    void updateProductById(ProductVo productVo);
}
