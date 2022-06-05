package com.hcy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.mapper.CartMapper;
import com.hcy.mapper.ProductMapper;
import com.hcy.mapper.SellerMapper;
import com.hcy.mapper.UserMapper;
import com.hcy.pojo.Cart;
import com.hcy.pojo.Product;
import com.hcy.pojo.Seller;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.CartVo;
import com.hcy.pojo.vo.ProductVo;
import com.hcy.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OnlineShoppingTests {
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    ProductMapper productMapper;
    
    @Autowired
    SellerMapper sellerMapper;
    
    @Autowired
    CartMapper cartMapper;
    
    @Autowired
    CartService cartService;
    
    @Test
    void contextLoads() {
    }
    
    @Test
    public void testInsertIntoCart() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(4);
        cart.setCartItemPrice(58L);
        cartMapper.insertIntoCart(cart);
    }
    
    @Test
    public void testUpdateCartItemNumByCid() {
        cartMapper.updateCartItemNumByCid(1, 5);
    }
    @Test
    public void testSelectByUidAndPid() {
        Cart cart = cartMapper.selectByUidAndPid(1, 1);
        System.out.println(cart);
    }

    @Test
    public void testSelectProductById() {
        Product product = productMapper.selectById(1);
        System.out.println(product);
    }
    
    @Test
    public void testInsertCart() {
        cartService.insertIntoCart(1,1);
    }
    
    @Test
    public void testSelectCartVo() {
        List<CartVo> cartVos = cartMapper.selectCartVoByUid(1);
        System.out.println(cartVos);
    }
    
    @Test
    public void testFindByCid() {
        Cart cart = cartMapper.selectByCid(1);
        System.out.println(cart);
    }
    
    @Test
    public void testDeleteByCid() {
        cartMapper.deleteByCid(7);
    }
    
    @Test
    public void testUpdateProductNumById() {
        productMapper.updateProductNumById(1,8888);
    }
}
