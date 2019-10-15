package com.example.hot_push.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){
        return "你好";
    }

    @GetMapping("/chenhua")
    public String chenhua(){
        return "陈华";
    }

    @GetMapping("/huachen")
    public String huachen(){
        return "华诚";
    }

    @GetMapping("/jiangyong")
    public String jiangyong(){
        return "剑勇";
    }


    @GetMapping("/zhangsan")
    public String zhangsan(){
        return "张三";
    }

    @GetMapping("/lisi")
    public String lisi(){
        return "李四";
    }

}
