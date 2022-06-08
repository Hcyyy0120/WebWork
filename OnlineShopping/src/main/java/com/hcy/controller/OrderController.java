package com.hcy.controller;


import com.hcy.pojo.Order;
import com.hcy.pojo.User;
import com.hcy.pojo.vo.OrderVo;
import com.hcy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/allIsTrue/{oid}")
    public Map<String,Object> allOrderItemIsTrue(@PathVariable("oid") Integer oid) {
        HashMap<String, Object> map = new HashMap<>();
        boolean tag = orderService.selectOrderItemStateCountByOid(oid);
        System.out.println("tag"  + tag);
        if(tag) {
            map.put("message",true);
        } else {
            map.put("message",false);
        }
        return map;
    }
    
    
    /**
     * 有bug，不能选择购物车的部分商品进行结算（可以修复，但不是现在）
     * 前端要改为gotoPay(multipleSelection)
     * 传入multipleSelection--->选中的数据集合
     * @param session
     * @return123
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
    
    @GetMapping("/delete/{oid}")
    void deleteOrderByOid(@PathVariable("oid") Integer oid) {
        orderService.deleteOrderByOid(oid);
    }
}
