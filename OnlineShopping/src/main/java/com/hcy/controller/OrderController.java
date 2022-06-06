package com.hcy.controller;


import com.hcy.pojo.Order;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.OrderVo;
import com.hcy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    /**
     * 有bug，不能选择购物车的部分商品进行结算（可以修复，但不是现在）
     * 前端要改为gotoPay(multipleSelection)
     * 传入multipleSelection--->选中的数据集合
     * @param session
     * @return
     */
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
    
    @PostMapping("/update/{oid}")
    public void updateOrderState(@PathVariable("oid") Integer oid) {
        //System.out.println("oidoidoidoidoidoid" + oid);
        orderService.updateOrderState(oid);
    }
    
}
