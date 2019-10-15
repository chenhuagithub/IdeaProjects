package com.atguigu.swaggerdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/hello")
public class HelloController {


    @GetMapping
    public String updateHello(String str){
        return str;
    }


    @DeleteMapping
    public String deleteHello(String str){
        return str;
    }

}
