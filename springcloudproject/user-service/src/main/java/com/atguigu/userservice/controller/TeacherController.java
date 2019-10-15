package com.atguigu.userservice.controller;

import com.atguigu.userservice.bean.Teacher;
import com.atguigu.userservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacher/findById/{id}")
    public Teacher findById(@PathVariable("id") Integer id){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return teacherService.findById(id);
    }

}
