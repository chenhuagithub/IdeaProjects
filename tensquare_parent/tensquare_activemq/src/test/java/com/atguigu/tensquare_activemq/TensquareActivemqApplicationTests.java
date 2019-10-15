package com.atguigu.tensquare_activemq;

import com.atguigu.tensquare_activemq.utils.Queue_Produce;
import com.atguigu.tensquare_activemq.utils.VerificationCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TensquareActivemqApplicationTests {

    @Autowired
    Queue_Produce queue_produce;

    @Test
    public void contextLoads() {

        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("mobile", "13267869217");
        hashMap.put("checkcode", RandomStringUtils.random(6, false, true));
        queue_produce.produceMsg(hashMap);


    }


    @Autowired
    private VerificationCode verificationCode;

    @Test
    public void test4a(){
        String random = RandomStringUtils.random(6, false, true);
        System.out.println(random);
//        verificationCode.SingleSend("13267869217", "111111");
    }


}
