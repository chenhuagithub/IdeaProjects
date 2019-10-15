package com.atguigu.tensquarebase;

import com.atguigu.tensquare_common.util.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.atguigu.tensquarebase.dao")
@EnableSwagger2
@EnableEurekaClient
public class TensquareBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareBaseApplication.class, args);
    }

    @Autowired
    Environment environment;


    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1, 1);
    }

    @Bean
    public Docket docket(){
        // 设置环境
        Profiles profiles = Profiles.of("prod");
        // 判断环境
        boolean isEnable = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(!isEnable);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }


}
