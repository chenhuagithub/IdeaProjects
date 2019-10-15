package com.atguigu.bootmqconsumer.utils;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Queue_Comsumer {

    // 接受哪个消息队列
    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage) throws JMSException{
        System.out.println("************消费者收到消息:"+textMessage.getText());

    }

}
