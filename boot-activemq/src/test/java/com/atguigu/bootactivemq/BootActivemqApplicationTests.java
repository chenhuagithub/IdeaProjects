package com.atguigu.bootactivemq;

import com.atguigu.bootactivemq.utils.Queue_Produce;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Queue;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootActivemqApplicationTests {

    @Autowired
    private Queue_Produce produce;


    @Test
    public void contextLoads() {

        produce.produceMsg();


    }

}
