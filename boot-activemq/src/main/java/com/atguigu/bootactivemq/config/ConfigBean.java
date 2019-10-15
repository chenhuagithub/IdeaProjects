package com.atguigu.bootactivemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import java.util.Queue;

@Configuration
@EnableJms
public class ConfigBean {

    @Value("${myqueue}")
    private String myqueue;

    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue(myqueue);
    }


}
