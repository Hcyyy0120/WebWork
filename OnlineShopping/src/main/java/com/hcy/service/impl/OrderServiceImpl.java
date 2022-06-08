package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.mapper.OrderItemMapper;
import com.hcy.mapper.UserMapper;
import com.hcy.pojo.Order;
import com.hcy.pojo.OrderItem;
import com.hcy.pojo.vo.CartVo;
import com.hcy.pojo.vo.OrderVo;
import com.hcy.service.CartService;
import com.hcy.service.OrderService;
import com.hcy.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
* @author 16691
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2022-06-06 09:08:15
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService{
    
    @Autowired
    private CartService cartService;
    
    @Autowired
    private OrderMapper orderMapper;
    
    @Autowired
    private OrderItemMapper orderItemMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public Order createOrder(Integer uid) {//前端传回用户uid------->自力更生从session里取
        List<CartVo> cartVos = cartService.selectCartVoByUid(uid);//要下单的列表
        Order order = new Order();
        Long totalPrice = 0L;
        
        for(CartVo cartVo : cartVos) {
            totalPrice += cartVo.getCartItemPrice()*cartVo.getCartItemNum();
        }
        
        //补全Order信息
        order.setTotalPrice(totalPrice);
        order.setUid(uid);
        order.setRecvName(userMapper.selectByUid(uid).getUsername());
        
        orderMapper.insertOrder(order);
        System.out.println("order============" + order);
        Integer oid = order.getOid();
        System.out.println("oid============" + oid);
        OrderItem orderItem = new OrderItem();
        //补全OrderItem信息
        for(CartVo cartVo : cartVos) {
            orderItem.setOid(order.getOid());
            orderItem.setPid(cartVo.getPid());
            orderItem.setTitle(cartVo.getTitle());
            orderItem.setPrice(cartVo.getCartItemPrice()* cartVo.getCartItemNum());
            orderItem.setNum(cartVo.getCartItemNum());
            
            orderItemMapper.insertOrderItem(orderItem);
        }
        
        return order;
    }
    
    @Override
    public List<OrderVo> selectOrderVoByUid(Integer uid) {
        return orderMapper.selectOrderVoByUid(uid);
    }
    
    @Override
    public void updateOrderState(Integer oid) {
        orderMapper.updateOrderState(oid);
    }
    
    @Override
    public void deleteOrderByOid(Integer oid) {
        orderMapper.deleteOrderByOid(oid);
    }
    
    @Override
    public boolean selectOrderItemStateCountByOid(Integer oid) {
        int count1 = orderMapper.selectOrderItemStateCountByOid(oid);
        int count2 = orderMapper.selectOrderItemCountByOid(oid);
        System.out.println("count1===" + count1);
        System.out.println("count2===" + count1);
        System.out.println(count1 == count2);
        if (count1 == count2) {
            return true;
        } else {
            return false;
        }
        
    }
    
}




