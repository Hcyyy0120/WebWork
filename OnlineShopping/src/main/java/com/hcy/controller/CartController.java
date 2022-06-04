package com.hcy.controller;

import com.hcy.pojo.User;
import com.hcy.pojo.vo.CartVo;
import com.hcy.pojo.vo.ProductVo;
import com.hcy.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    
    @PostMapping("/insert")
    public void insertIntoCart(@RequestBody ProductVo productVo, HttpSession session) {
        User user = (User) session.getAttribute("user");
        cartService.insertIntoCart(user.getUid(), productVo.getId());
    }
    
    @GetMapping("/select")
    public List<CartVo> selectCartVoByUid(HttpSession session) {
        User user = (User)session.getAttribute("user");
        return cartService.selectCartVoByUid(user.getUid());
    }
}
