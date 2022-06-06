package com.hcy.service;

import com.hcy.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
* @author 16691
* @description 针对表【t_user】的数据库操作Service
* @createDate 2022-05-30 20:02:57
*/
public interface UserService extends IService<User> {
    User selectByUsername(String username);
    
    
    int insertSelective(User user);
    
    void rememberUser(HttpServletResponse response, User user);
    
    Map<String,Object> autoLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session);
}
