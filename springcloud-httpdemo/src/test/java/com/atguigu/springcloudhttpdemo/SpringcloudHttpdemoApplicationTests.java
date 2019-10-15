package com.atguigu.springcloudhttpdemo;

import com.atguigu.springcloudhttpdemo.bean.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringcloudHttpdemoApplicationTests {

    @Autowired
    RestTemplate restTemplate;


    @Test
    public void contextLoads() {
        Teacher user = restTemplate.getForObject("http://localhost:8080/teacher/1", Teacher.class);
        System.out.println(user);

    }

}
