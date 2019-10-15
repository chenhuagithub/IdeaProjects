package com.atguigu.tenquare_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TenquareEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenquareEurekaApplication.class, args);
    }

}
