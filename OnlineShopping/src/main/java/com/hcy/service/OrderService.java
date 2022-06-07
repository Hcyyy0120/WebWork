package com.hcy.service;

import com.hcy.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hcy.pojo.vo.OrderVo;

import java.util.List;

/**
* @author 16691
* @description 针对表【t_order】的数据库操作Service
* @createDate 2022-06-06 09:08:15
*/
public interface OrderService extends IService<Order> {
    Order createOrder(Integer uid);
    
    List<OrderVo> selectOrderVoByUid(Integer uid);
    
    void updateOrderState(Integer oid);
    
    void deleteOrderByOid(Integer oid);
}
