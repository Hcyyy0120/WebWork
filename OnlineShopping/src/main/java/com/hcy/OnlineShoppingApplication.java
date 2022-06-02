package com.hcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hcy.mapper")
public class OnlineShoppingApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(OnlineShoppingApplication.class, args);
    }
    
}
