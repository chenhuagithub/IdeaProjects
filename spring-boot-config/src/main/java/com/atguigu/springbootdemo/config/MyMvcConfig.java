package com.atguigu.springbootdemo.config;

import com.atguigu.springbootdemo.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;


@Configuration
public class MyMvcConfig implements WebMvcConfigurer {



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
        registry.addViewController("/login").setViewName("login");
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *  addPathPatterns: 添加拦截的请求
         *  excludePathPatterns: 不拦截的请求
         */
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login" ,"/login", "/login.html", "/index.html");
    }
}
