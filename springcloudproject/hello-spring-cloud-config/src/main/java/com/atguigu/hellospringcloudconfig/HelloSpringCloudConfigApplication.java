package com.atguigu.hellospringcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HelloSpringCloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringCloudConfigApplication.class, args);
    }

}
