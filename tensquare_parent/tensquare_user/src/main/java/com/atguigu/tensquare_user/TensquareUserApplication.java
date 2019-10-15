package com.atguigu.tensquare_user;

import com.atguigu.tensquare_common.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.atguigu.tensquare_user.dao")
@EnableEurekaClient
public class TensquareUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareUserApplication.class, args);
    }



    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
