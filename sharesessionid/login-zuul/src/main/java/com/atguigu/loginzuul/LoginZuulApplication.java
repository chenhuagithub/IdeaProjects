package com.atguigu.loginzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class LoginZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginZuulApplication.class, args);
    }

}
