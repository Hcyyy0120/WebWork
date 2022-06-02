package com.hcy.controller;

import com.hcy.pojo.Seller;
import com.hcy.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {
    
    @Autowired
    private SellerService sellerService;
    
    @PostMapping("/login")
    public Map<String, Object> SellerLogin(@RequestBody Seller seller, HttpSession session) {
        Seller checkSeller = sellerService.selectBySellerName(seller.getSellerName());
        Map<String, Object> map = new HashMap<>();
        //判断从数据库中查询出来的seller是否为空
        if (checkSeller != null && seller.getPassword().equals(checkSeller.getPassword())) {
            map.put("status", true);
            //map.put("message", "登录成功,点击确定跳转到主页");
            map.put("seller", checkSeller);
            session.setAttribute("seller", checkSeller);
        } else {
            //通过商家名查询该商家是否存在数据库
            Seller reSeller = sellerService.selectBySellerName(seller.getSellerName());
            if (reSeller != null) {
                //如果存在
                map.put("status", false);
                map.put("message", "密码错误");
            } else {
                map.put("status", false);
                map.put("message", "商家不存在");
            }
        }
        return map;
    }
    
    @PostMapping("/reg")
    public Map<String, Object> SellerReg(@RequestBody Seller seller) {
        Seller checkSeller = sellerService.selectBySellerName(seller.getSellerName());//在数据库里查找是否已存在
        HashMap<String, Object> map = new HashMap<>();
        if (checkSeller != null) {
            map.put("status", false);
            map.put("message", "用户已存在");
            return map;
        }
        int res = sellerService.insertSelective(seller);
        if (res == 0) {
            map.put("status", false);
            map.put("message", "注册失败");
            return map;
        }
        map.put("status", true);
        map.put("message", "注册成功");
        return map;
    }
}
