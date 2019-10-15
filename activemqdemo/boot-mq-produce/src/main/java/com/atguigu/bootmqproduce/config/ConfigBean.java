package com.atguigu.bootmqproduce.config;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Value("${myqueue}")
    private String myqueue;


    @Bean
    public ActiveMQQueue activeMQQueue(){
        return new ActiveMQQueue(myqueue);
    }


}
