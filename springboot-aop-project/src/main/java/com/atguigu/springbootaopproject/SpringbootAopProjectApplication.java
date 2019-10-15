package com.atguigu.springbootaopproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.atguigu.springbootaopproject.dao")
public class SpringbootAopProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAopProjectApplication.class, args);
    }

}
