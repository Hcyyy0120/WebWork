package com.hcy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.mapper.ProductMapper;
import com.hcy.mapper.SellerMapper;
import com.hcy.mapper.UserMapper;
import com.hcy.pojo.Seller;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.ProductVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OnlineShoppingApplicationTests {
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    ProductMapper productMapper;
    
    @Autowired
    SellerMapper sellerMapper;
    
    @Test
    void contextLoads() {
    }
    
    @Test
    public void testInsert() {
        Seller admin = sellerMapper.selectBySellerName("admin");
        System.out.println(admin);
    }
    
    @Test
    public void testSellerInsert() {
        Seller seller = new Seller(null,"卖东西的人","123",null);
        int i = sellerMapper.insertSelective(seller);
        System.out.println("i====" + i);
    }
}
