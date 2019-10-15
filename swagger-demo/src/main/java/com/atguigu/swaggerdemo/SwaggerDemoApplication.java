package com.atguigu.swaggerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class SwaggerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerDemoApplication.class, args);
    }




//    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(false)
                // 参数忽略
                .ignoredParameterTypes(HttpSession.class, HttpServletRequest.class)
                // 选择扫描的接口
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.atguigu.swaggerdemo.controller"))
//                .paths(PathSelectors.ant("/hello/**"))
                .build();
    }


    private ApiInfo apiInfo(){
        Contact contact = new Contact("张三", "aaa.com", "111@qq.com");
        return new ApiInfo("swagger学习文档",
                "这是学习swagger时生成的文档信息",
                "v1.0",
                "http://localhost:8080",
                contact,
                "",
                "",
                new ArrayList<>()
                );
    }

}
