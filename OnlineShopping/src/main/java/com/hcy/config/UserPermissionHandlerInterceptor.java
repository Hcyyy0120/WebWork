package com.hcy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserPermissionHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user != null) {//若此时用户登录
            response.sendRedirect("/pages/error.html");
            System.out.println("UserPermission:no permission");
            return true;
        } else {
            return false;
        }
    }
}
