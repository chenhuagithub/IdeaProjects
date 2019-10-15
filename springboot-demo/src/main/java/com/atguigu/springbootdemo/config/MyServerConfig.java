package com.atguigu.springbootdemo.config;

import com.atguigu.springbootdemo.filter.MyFilter;
import com.atguigu.springbootdemo.listener.MyListener;
import com.atguigu.springbootdemo.servlet.MyServlet;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    // 配置服务器
    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        // 配置端口号
        tomcatServletWebServerFactory.setPort(8888);
        return tomcatServletWebServerFactory;
    }


    // 注册三大组件
    @Bean
    public ServletRegistrationBean myServletRegister(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilterRegister(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        // 过滤器处理的哪些请求
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListennerRegister(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;

    }


}
