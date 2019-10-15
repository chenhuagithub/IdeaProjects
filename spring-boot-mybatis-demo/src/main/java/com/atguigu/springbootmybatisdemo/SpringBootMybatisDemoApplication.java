package com.atguigu.springbootmybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 扫描接口
@MapperScan(value = "com.atguigu.springbootmybatisdemo.mapper")
@SpringBootApplication
public class SpringBootMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisDemoApplication.class, args);
    }

}
