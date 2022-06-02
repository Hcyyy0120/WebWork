package com.hcy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hcy.pojo.User;
import com.hcy.service.UserService;
import com.hcy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 16691
 * @description 针对表【t_user】的数据库操作Service实现
 * @createDate 2022-05-30 20:02:57
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }
    
    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }
    
    @Override
    public void rememberUser(HttpServletResponse response, User user) {
        Cookie cookie1 = new Cookie("username", user.getUsername());
        Cookie cookie2 = new Cookie("userPwd", user.getPassword());
        
        cookie1.setMaxAge(60*60);
        cookie2.setMaxAge(60*60);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
    
    @Override
    public Map<String, Object> autoLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Cookie[] cookies = request.getCookies();
        HashMap<String, Object> map = new HashMap<>();
        String username = null;
        String userPwd = null;
        if (cookies != null) {
            //遍历Cookie获取cookie中的键值对
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                if ("username".equals(cookieName)) {
                    username = cookieValue;
                } else if ("userPwd".equals(cookieName)) {
                    userPwd = cookieValue;
                }
            }
            if (username != null && userPwd != null) {
                User user = selectByUsername(username);
                if (user == null) {
                    map.put("status", false);
                    map.put("message", "用户名或密码有误");
                } else {
                    map.put("status", true);
                    session.setAttribute("user", user);
                }
                return map;
            }
        }
        map.put("status", false);
        return map;
    }
    
    
}




