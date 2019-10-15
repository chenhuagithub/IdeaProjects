package com.atguigu.springbootdemo.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 告诉springboot这是配置类
@Configuration
public class TomcatCustomizer {

    // 把返回对象加入spring容器
//    @Bean
//    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        tomcatServletWebServerFactory.setPort(8888);
//        return tomcatServletWebServerFactory;
//    }


}
