package com.atguigu.tensquare_user.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 注册拦截器
         */
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login/**");


    }
}





