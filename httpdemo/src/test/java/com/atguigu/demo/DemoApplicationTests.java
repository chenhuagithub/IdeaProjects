package com.atguigu.demo;

import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void contextLoads() {
//
//        User user = restTemplate.getForObject("http://localhost:8080/teacher/1", User.class);
//        System.out.println(user);

    }

}
