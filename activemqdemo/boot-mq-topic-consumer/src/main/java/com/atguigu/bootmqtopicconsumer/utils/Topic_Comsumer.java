package com.atguigu.bootmqtopicconsumer.utils;

import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Topic_Comsumer {


    @JmsListener(destination = "${myTopic}")
    public void receive(TextMessage textMessage) throws JmsException{
        try {
            System.out.println("主题消费者订阅的消息:"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
