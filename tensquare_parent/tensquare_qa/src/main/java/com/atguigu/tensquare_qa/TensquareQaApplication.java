package com.atguigu.tensquare_qa;

import com.atguigu.tensquare_common.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.atguigu.tensquare_qa.dao")
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableFeignClients
public class TensquareQaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareQaApplication.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
