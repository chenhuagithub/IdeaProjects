package com.atguigu.tensquare_friend;

import com.atguigu.tensquare_friend.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class TensquareFriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TensquareFriendApplication.class, args);
    }


    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

}
