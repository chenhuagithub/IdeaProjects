package com.atguigu.shiroproject.config;


import com.atguigu.shiroproject.utils.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {


    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguaration.shirFilter");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 添加shiro的内置过滤器
        /**
         *  常用过滤器
         *      anon: 无需认证(登录)可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用remenberme的功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/add", "authc");
//        filterMap.put("/update", "authc");
        filterMap.put("/register", "anon");
        filterMap.put("/index", "anon");
        filterMap.put("/login", "anon");
        // 授权过滤器
        filterMap.put("/update", "perms[user:update]");
        filterMap.put("/add", "perms[user:add]");
        filterMap.put("/*", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        // 登录跳转页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        // 设置未授权访问地址
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        return shiroFilterFactoryBean;

    }





    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }






    /**
     * 创建Realm
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }




}
