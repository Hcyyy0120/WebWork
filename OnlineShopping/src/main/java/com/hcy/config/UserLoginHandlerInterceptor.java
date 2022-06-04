package com.hcy.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功时候,应该有用户的session
        Object user = request.getSession().getAttribute("user");
        Object seller = request.getSession().getAttribute("seller");
/*        if(user == null || seller == null) {
            response.sendRedirect("/pages/index.html");
            //request.setAttribute("loginMsg","没有权限，请登录");
            System.out.println("no permission");
            return false;
        } else {
            return true;
        }*/
        
        if(user != null || seller != null ) {
            return true;
        } else {
            response.sendRedirect("/pages/index.html");
            System.out.println("no permission");
            return false;
        }
    }
    
}
