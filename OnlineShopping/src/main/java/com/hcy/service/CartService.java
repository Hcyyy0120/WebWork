package com.hcy.service;

import com.hcy.pojo.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 16691
* @description 针对表【t_cart】的数据库操作Service
* @createDate 2022-06-04 11:52:28
*/
public interface CartService extends IService<Cart> {
    
    /**
     * 添加商品到购物车
     * @param uid 用户id
     * @param pid 商品id
     */
    void insertIntoCart(Integer uid, Integer pid);
}
