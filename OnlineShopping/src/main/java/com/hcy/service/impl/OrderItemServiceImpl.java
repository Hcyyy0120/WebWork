package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.pojo.OrderItem;
import com.hcy.service.OrderItemService;
import com.hcy.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

/**
* @author 16691
* @description 针对表【t_order_item】的数据库操作Service实现
* @createDate 2022-06-06 09:08:20
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem>
    implements OrderItemService{

}




