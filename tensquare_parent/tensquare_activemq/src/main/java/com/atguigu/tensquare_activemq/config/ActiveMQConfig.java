package com.atguigu.tensquare_activemq.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.ConnectionFactory;

@Configuration
@EnableScheduling
public class ActiveMQConfig {

    @Value("${myqueue}")
    private String myqueue;


    @Bean
    public ActiveMQQueue activeMQQueue(){
        return new ActiveMQQueue(myqueue);
    }



}
