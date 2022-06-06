package com.hcy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.mapper.*;
import com.hcy.pojo.*;
import com.hcy.pojo.vo.CartVo;
import com.hcy.pojo.vo.OrderVo;
import com.hcy.pojo.vo.ProductVo;
import com.hcy.service.CartService;
import com.hcy.service.OrderService;
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
    
    @Autowired
    OrderMapper orderMapper;
    
    @Autowired
    OrderService orderService;
    
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
    
    @Test
    public void testSelectByUid() {
        User user = userMapper.selectByUid(1);
        System.out.println(user);
    }
    
    @Test
    public void testCreateOrder() {
        Order order = orderService.createOrder(1);
        System.out.println(order);
    }
    
    @Test
    public void testSelectOrderByOid() {
        List<OrderVo> orderVos = orderMapper.selectOrderVoByOid(1);
        System.out.println(orderVos);
    }
}
