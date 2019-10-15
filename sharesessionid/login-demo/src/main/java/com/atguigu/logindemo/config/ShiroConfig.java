package com.atguigu.logindemo.config;


import com.atguigu.logindemo.utils.RedisSessionDao;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
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
        filterMap.put("/user/register", "anon");
        filterMap.put("/user/index", "anon");
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/tologin", "anon");
        filterMap.put("/user/toregister", "anon");
        // 授权过滤器
        filterMap.put("/user/add", "perms[admin]");
        filterMap.put("/user/update", "perms[admin]");
//        filterMap.put("/user/select", "perms[user admin]");
        filterMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        // 登录跳转页面
        shiroFilterFactoryBean.setLoginUrl("/user/tologin");
        // 设置未授权访问地址
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noAuth");
        return shiroFilterFactoryBean;

    }





    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean
    public SecurityManager securityManager(ShiroRealm shiroRealm, RedisSessionDao redisSessionDao){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        securityManager.setRememberMeManager(null);
        securityManager.setSessionManager(defaultSessionManager(redisSessionDao));
        return securityManager;
    }


//    @Bean
//    public RedisSessionDao redisSessionDao(){
//        return new RedisSessionDao();
//    }




    /**
     * 创建Realm
     */
    @Bean
    public ShiroRealm shiroRealm(){
        return new ShiroRealm();
    }

    @Value("${session.redis.expireTime}")
    private Integer expireTime;

    /**
     * 将SessionDao加入到SessionManager中
     * @return
     */
    @Bean
    public DefaultWebSessionManager defaultSessionManager(RedisSessionDao redisSessionDao){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(expireTime * 1000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionDAO(redisSessionDao);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookie(new SimpleCookie("JSESSIONID"));
        return sessionManager;
    }



}
