package com.atguigu.tensquare_recruit;

import com.atguigu.tensquare_common.util.IdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.atguigu.tensquare_recruit.dao")
public class TensquareRecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareRecruitApplication.class, args);
    }


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

}
