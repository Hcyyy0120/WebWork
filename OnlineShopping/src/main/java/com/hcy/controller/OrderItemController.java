package com.hcy.controller;

import com.hcy.pojo.dto.CartItemDto;
import com.hcy.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
    
    @Autowired
    private OrderItemService orderItemService;
    
    @PostMapping("/update")
    public void updateOrderItemStateByOidAndPid(@RequestBody CartItemDto cartItemDto) {
        
        Integer[] pid = cartItemDto.getPid();
        Integer oid = cartItemDto.getOid();
        System.out.println("pid==========" + pid);
        System.out.println("oid==========" + oid);
        orderItemService.updateOrderItemStateByOidAndPid(oid,pid);
    }
}
