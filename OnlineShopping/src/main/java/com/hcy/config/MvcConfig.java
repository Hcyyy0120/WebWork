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
        registry.addInterceptor(userLoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/pages/index.html",
                        "/user/reg", "/user/check",
                        "/user/login/*","/css/**",
                        "/js/**", "/img/**",
                        "/plugins/**","/seller/login",
                        "/seller/reg");
        
        registry.addInterceptor(sellerLoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/pages/index.html",
                        "/css/**","/js/**","/img/**",
                        "/plugins/**");
    }
    
    
    @Bean
    public UserLoginHandlerInterceptor userLoginHandlerInterceptor() {
        return new UserLoginHandlerInterceptor();
    }
    
    public SellerLoginHandlerInterceptor sellerLoginHandlerInterceptor() {
        return new SellerLoginHandlerInterceptor();
    }
}
