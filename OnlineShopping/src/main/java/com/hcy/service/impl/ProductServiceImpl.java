package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.pojo.Product;
import com.hcy.pojo.vo.ProductVo;
import com.hcy.service.ProductService;
import com.hcy.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_product】的数据库操作Service实现
* @createDate 2022-06-03 12:13:17
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService{
    
    @Autowired
    private ProductMapper productMapper;
    
    @Override
    public List<ProductVo> getAllProductVo(ProductVo productVo) {
        return productMapper.getAllProductVo();
    }
    
    @Override
    public List<ProductVo> selectAllByCondition(String title, String typeName,Long beginPrice, Long endPrice,String sellerName) {
        return productMapper.selectAllByCondition(title,typeName,beginPrice,endPrice,sellerName);
    }
    
    @Override
    public List<ProductVo> selectAllProductVoBySeller(String sellerName) {
        return productMapper.selectAllProductVoBySeller(sellerName);
    }
    
    @Override
    public void deleteProductById(ProductVo productVo) {
        productMapper.deleteProductById(productVo.getId());
    }
    
    @Override
    public void insertProduct(ProductVo productVo) {
        productMapper.insertProduct(productVo);
    }
    
    
}




