package com.atguigu.microservicecloudconfigclient3355.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @ResponseBody
    @GetMapping("/config")
    public String getconfig(){
        String str = "application:"+applicationName+"\tport:"+port;
        System.out.println("***************str:"+str);
        return str;
    }


}
