package com.hcy.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SellerLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object seller = request.getSession().getAttribute("seller");
        if(seller != null) {
            return true;
        } else {
            response.sendRedirect("/pages/index.html");
            System.out.println("seller:no permission");
            return false;
        }
    }
}
