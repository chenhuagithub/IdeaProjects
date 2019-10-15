package com.atguigu.springbootmybatisdemo.controller;

import com.atguigu.springbootmybatisdemo.bean.Teacher;
import com.atguigu.springbootmybatisdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable("id") Integer id) {
        System.out.println("===============");
        System.out.println(id);
        System.out.println("================");
        Teacher teacher = teacherService.getTeacherById(id);
        return teacher;
    }

    @PostMapping("/teacher/insertTeacher")
    public Teacher insertTeacher(Teacher teacher) {
        System.out.println("teacher-->"+teacher);
        teacherService.insertTeacher(teacher);
        return teacher;
    }


    @PostMapping("/teacher/updateTeacher")
    public int updateTeacher(Teacher teacher) {
        int i = teacherService.updateTeacher(teacher);

        return i;
    }

    @GetMapping("/teacher/deleteTeacher")
    public int deleteTeacher(Integer id) {
        int i = teacherService.deleteTeacher(id);
        return i;
    }
}
