package com.atguigu.demo.configTest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Config {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/config")
    public String config(){
        String str = "port:"+port+"\tname:"+name;
        return str;
    }

}
