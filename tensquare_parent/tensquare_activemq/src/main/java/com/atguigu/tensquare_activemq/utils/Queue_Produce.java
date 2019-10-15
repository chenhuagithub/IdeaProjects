package com.atguigu.tensquare_activemq.utils;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

@Component
public class Queue_Produce {

//    @Autowired
//    public JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    JmsTemplate jmsTemplate;


    @Autowired
    public ActiveMQQueue activeMQQueue;

    @Autowired
    private VerificationCode verificationCode;


    public void produceMsg(Map<String, Object> map){

        jmsTemplate.send(activeMQQueue,new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                for(String key : map.keySet()){
                    String value = (String)map.get(key);
                    mapMessage.setString(key, value);
                }
                return mapMessage;
            }
        });

    }




    @JmsListener(destination = "${myqueue}")
    public void receive(MapMessage mapMessage) throws JMSException {
//        System.out.println(mapMessage.getString("mobile"));
//        System.out.println(mapMessage.getString("checkcode"));
        String mobile = mapMessage.getString("mobile");
        String checkcode = mapMessage.getString("checkcode");
        RandomStringUtils.random(6, false, true);
        verificationCode.SingleSend(mobile, checkcode);

    }



//
//    @Scheduled(fixedDelay = 3000)
//    public void produceMsgScheduled(){
//        jmsMessagingTemplate.convertAndSend(activeMQQueue, "*****"+ UUID.randomUUID().toString().substring(0, 8));
//        System.out.println("send message ok~");
//    }


}
