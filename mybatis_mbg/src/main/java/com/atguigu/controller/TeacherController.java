package com.atguigu.controller;

import com.atguigu.bean.Teacher;
import com.atguigu.service.TeacherService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/getall")
    public String getAll(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page, Model model){
        PageHelper.startPage(page, 10);
        List<Teacher> teacherList = teacherService.getall();
        PageInfo<Teacher> info = new PageInfo<>(teacherList);

        System.out.println("当前页码:"+info.getPageNum());
        System.out.println("总页码:"+info.getPages());
        System.out.println("总记录数:"+info.getTotal());
        System.out.println("当前页有几条记录"+info.getSize());
        System.out.println("当前页的pageSize:"+info.getPageSize());
        System.out.println("前一页:"+info.getPrePage());
        System.out.println("结果:"+info.getList());

        model.addAttribute("teacher", info.getList());

        return "success";
    }

}
