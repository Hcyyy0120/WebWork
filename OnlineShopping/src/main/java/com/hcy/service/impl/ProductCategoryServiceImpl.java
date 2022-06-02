package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.pojo.ProductCategory;
import com.hcy.service.ProductCategoryService;
import com.hcy.mapper.ProductCategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 16691
* @description 针对表【t_product_category】的数据库操作Service实现
* @createDate 2022-06-01 11:33:11
*/
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory>
    implements ProductCategoryService{

}




