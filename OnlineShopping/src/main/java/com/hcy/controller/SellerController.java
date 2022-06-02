package com.hcy.controller;

import com.hcy.pojo.User;
import com.hcy.service.UserService;
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
    private UserService userService;
    
    @PostMapping("/login")
    public Map<String, Object> UserLogin(@RequestBody User user, HttpSession session) {
        User checkUser = userService.selectByUsername(user.getUsername());
        Map<String, Object> map = new HashMap<>();
        //判断从数据库中查询出来的user是否为空
        if (checkUser != null && user.getPassword().equals(checkUser.getPassword())) {
            map.put("status", true);
            map.put("message", "登录成功,点击确定跳转到主页");
            map.put("user", checkUser);
            session.setAttribute("user", checkUser);
        } else {
            //通过用户名查询该用户是否存在数据库
            User reUser = userService.selectByUsername(user.getUsername());
            if (reUser != null) {
                //如果存在
                map.put("status", false);
                map.put("message", "密码错误");
            } else {
                map.put("status", false);
                map.put("message", "用户名不存在");
            }
        }
        return map;
    }
    
}
