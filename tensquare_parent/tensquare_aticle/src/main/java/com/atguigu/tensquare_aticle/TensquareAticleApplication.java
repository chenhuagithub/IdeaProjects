package com.atguigu.tensquare_aticle;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.atguigu.tensquare_aticle.dao")
@EnableEurekaClient
//@EnableCaching
public class TensquareAticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareAticleApplication.class, args);
    }





}
