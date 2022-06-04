package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.pojo.Cart;
import com.hcy.service.CartService;
import com.hcy.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author 16691
* @description 针对表【t_cart】的数据库操作Service实现
* @createDate 2022-06-04 11:52:28
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




