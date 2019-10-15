package com.atguigu.tokenproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.tokenproject.dao")
public class TokenProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenProjectApplication.class, args);
    }

}
