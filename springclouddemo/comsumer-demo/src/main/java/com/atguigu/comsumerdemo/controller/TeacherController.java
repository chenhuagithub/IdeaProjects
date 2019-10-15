package com.atguigu.comsumerdemo.controller;

import com.atguigu.comsumerdemo.bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TeacherController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public Teacher findById(@RequestParam("id") Integer id){
        System.out.println("consumer被访问");
        Teacher forObject = restTemplate.getForObject("http://localhost:8088//teacher/findById?id=" + id, Teacher.class);
        return forObject;
    }

}
