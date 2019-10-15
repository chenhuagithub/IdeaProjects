package com.atguigu.controller;

import com.atguigu.bean.Teacher;
import com.atguigu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    public TeacherController(){
        System.out.println("TeacherController被创建了");
    }

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getTeacher")
    public String getTeacher(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id, Model model){
        Teacher teacher = teacherService.getTeacher(1);
        model.addAttribute("teacher", teacher);
        return "success";
    }


}
