package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.mapper.ProductMapper;
import com.hcy.pojo.Cart;
import com.hcy.pojo.Product;
import com.hcy.service.CartService;
import com.hcy.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 16691
* @description 针对表【t_cart】的数据库操作Service实现
* @createDate 2022-06-04 11:52:28
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService{
    
    @Autowired
    private CartMapper cartMapper;
    
    @Autowired
    private ProductMapper productMapper;
    
    @Override
    public void insertIntoCart(Integer uid, Integer pid,Integer amount) {
        Cart result = cartMapper.selectByUidAndPid(uid, pid);
        if (result == null) {
            Cart cart = new Cart();
            cart.setPid(pid);
            cart.setUid(uid);
    
            //补全价格
            Product product = productMapper.selectById(pid);
            cart.setCartItemPrice(product.getPrice());
        } else {
            Integer num = result.getCartItemNum() + amount;
            cartMapper.updateCartItemNumByCid(result.getCid(),num);
        }
    }
}




