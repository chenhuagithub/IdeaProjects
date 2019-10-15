package com.atguigu.bootactivemq.utils;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Queue_Produce {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQQueue activeMQQueue;


    public void produceMsg(){
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "****"+ UUID.randomUUID().toString().substring(0, 8));
    }


    // 间隔时间3秒钟定投
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "scheduled****"+ UUID.randomUUID().toString().substring(0, 8));
        System.out.println("send message ok!");
    }



}
