package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class pathVariableController {

    @RequestMapping("/variable/{id}")
    public String pathVa(@PathVariable("id")String id){
        System.out.println("路径上的占位符--->"+id);
        return "success";
    }

}
