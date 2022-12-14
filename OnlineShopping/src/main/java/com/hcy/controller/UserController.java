package com.hcy.controller;

import com.hcy.pojo.User;
import com.hcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/*
@RequestBody是作用在形参列表上，用于将前台发送过来固定格式的数据【xml 格式或者 json等】封装为对应的 JavaBean 对象
@ResponseBody 注解表示该方法的返回的结果直接写入 HTTP 响应正文（ResponseBody）中
    返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    /**
     * 用户登录
     * @param user
     * @param isRemembered
     * @param response
     * @param request
     * @param session
     * @return
     */
    @PostMapping("/login/{isRemembered}")
    public Map<String, Object> UserLogin(@RequestBody User user, @PathVariable String isRemembered, HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        
        User checkUser = userService.selectByUsername(user.getUsername());
        Map<String, Object> map = new HashMap<>();
        //判断从数据库中查询出来的user是否为空
        if (checkUser != null && user.getPassword().equals(checkUser.getPassword())) {
            if ("1".equals(isRemembered)) {
                userService.rememberUser(response, checkUser);
            }
            session.setAttribute("user", checkUser);
            map.put("status", true);
            //map.put("message", "登录成功,点击确定跳转到主页");
            
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
    
    /**
     * 用户无需输入用户名和密码，自动登录
     * @param response
     * @param request
     * @param session
     * @return
     */
    @GetMapping("/check")
    public Map<String, Object> UserAutoLogin(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
        return userService.autoLogin(request, response, session);
    }
    
    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/reg")
    public Map<String, Object> UserReg(@RequestBody User user) {
        User checkUser = userService.selectByUsername(user.getUsername());//在数据库里查找是否已存在
        HashMap<String, Object> map = new HashMap<>();
        if (checkUser != null) {
            map.put("status", false);
            map.put("message", "用户已存在");
            return map;
        }
        int res = userService.insertSelective(user);
        if (res == 0) {
            map.put("status", false);
            map.put("message", "注册失败");
            return map;
        }
        map.put("status", true);
        map.put("message", "注册成功");
        return map;
    }
    
    /**
     * 获取用户信息（用户名）
     * @param session
     * @return
     */
    @GetMapping("/getUserInfo")
    public Map<String,Object> getUserInfo(HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        User user = (User)session.getAttribute("user");
        //System.out.println("user=====" + user);
        if(user!=null) {
            map.put("userInfo",user.getUsername());
            map.put("userId",user.getUid());
            return map;
        }
        map.put("userInfo","not_exists");
        return map;
    }
    
    /**
     * 用户注销/登出
     * @param session
     * @return
     */
    @GetMapping("/userLoginOut")
    public Map<String,Object> UserLoginOut(HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        session.invalidate();
        map.put("message","点击返回登录页(注：这将会清除浏览器中的所有cookie)");
        return map;
    }
}

