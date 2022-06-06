package com.hcy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvcConfigurationSupport不访问前端静态资源，所以适用于前后端分离；
 * WebMvcConfigurer不拦截静态资源，前后端不分离可以用。
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    /**
     * 仅仅需要页面跳转而没有具体的业务逻辑的代码
     * addViewController参数传入就是controller中的URL，setViewName中传入的参数就是原return的页面。
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("").setViewName("");
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor())
                .addPathPatterns("/**")//需要拦截的页面
                .excludePathPatterns("/pages/index.html",
                        "/user/reg", "/user/check", "/user/login/*",
                        "/seller/login", "/seller/reg",
                        "/css/**", "/js/**", "/img/**", "/plugins/**");//用户或商家在没登录时可以访问的页面
    
        registry.addInterceptor(userPermissionHandlerInterceptor())
                .addPathPatterns("/pages/manage.html","/pages/manage_order.html","/product/seller",
                        "/product/delete","/product/insert", "/product/update");//对于用户来说需要拦截的页面
    }
    
    
    @Bean
    public LoginHandlerInterceptor loginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }
    
    @Bean
    public UserPermissionHandlerInterceptor userPermissionHandlerInterceptor() {
        return new UserPermissionHandlerInterceptor();
    }

}
