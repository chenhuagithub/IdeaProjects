package com.atguigu.swaggerdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.swing.text.Document;

@Configuration
public class SwaggerConfig {

//    @Autowired
//    Environment environment;

//    @Bean
//    public Docket docket(){
//        // 设置环境
//        Profiles profiles = Profiles.of("dev", "test");
//        // 判断环境, 如果环境是dev或者test则返回true
//        boolean isEnable = environment.acceptsProfiles(profiles);
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(isEnable);
//
//    }

//    @Bean
//    public Docket docketUser(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("用户")
//                .select().paths(PathSelectors.ant("/user/**")).build();
//    }
//
//    @Bean
//    public Docket docketHello(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("你好")
//                .select().paths(PathSelectors.ant("/hello/**")).build();
//    }

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any()).build();
    }


}
