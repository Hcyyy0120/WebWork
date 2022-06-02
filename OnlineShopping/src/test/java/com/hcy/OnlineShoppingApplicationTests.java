package com.hcy;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hcy.mapper.ProductMapper;
import com.hcy.mapper.UserMapper;
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
    
    @Test
    void contextLoads() {
    }
    
    @Test
    public void testInsert() {
        /*List<ProductVo> productVos = productMapper.getAllProductVo();
        productVos.forEach(System.out::println);*/
    
/*        QueryWrapper<ProductVo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("item_type","title","sell_point","price","num","created_user");
        queryWrapper.like("title","书包")
                .between("price",10,100);
        List<ProductVo> productVos = productMapper.selectList(queryWrapper);
        productVos.forEach(System.out::println);*/
        List<ProductVo> productVos = productMapper.selectAllByCondition(null,null,0L,100L);
        productVos.forEach(System.out::println);
        
    }
}
