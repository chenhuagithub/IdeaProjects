package com.atguigu.activemqproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
public class ConfigBean {

    @Value("${myqueue}")
    private String myQueue;


//    @Bean
//    public Queue queue(){
////        return new
//    }


}
