package com.hcy.controller;


import com.hcy.pojo.Order;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.OrderVo;
import com.hcy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/create")
    public Order createOrder(HttpSession session) {
        User user = (User)session.getAttribute("user");
        Order createdOrder = orderService.createOrder(user.getUid());
        session.setAttribute("oid",createdOrder.getOid());
        return createdOrder;
    }
    
    @GetMapping("/select")
    public List<OrderVo> selectOrderVo(HttpSession session) {
        User user = (User)session.getAttribute("user");
        return orderService.selectOrderVoByUid(user.getUid());
    }
}
