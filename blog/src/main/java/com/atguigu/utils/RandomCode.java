package com.atguigu.utils;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomCode {


    public String getRandomCode(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 6 ; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }


}
