package com.atguigu.shiroproject;

import com.atguigu.shiroproject.utils.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.atguigu.shiroproject.dao")
public class ShiroProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroProjectApplication.class, args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
