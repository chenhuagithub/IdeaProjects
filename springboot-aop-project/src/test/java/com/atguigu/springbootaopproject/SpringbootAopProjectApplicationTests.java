package com.atguigu.springbootaopproject;

import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootAopProjectApplicationTests {

    @Test
    public void contextLoads() {

        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        // 加密所需要的盐
        textEncryptor.setPassword("chenhua");
        // 要加密的数据
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("123456");
        System.out.println("username: "+username);
        System.out.println("password: "+password);


    }

}
