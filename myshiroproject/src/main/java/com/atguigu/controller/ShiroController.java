package com.atguigu.controller;

import com.atguigu.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ShiroController {

    @Autowired
    ShiroService shiroService;

    @RequestMapping("/testShiroAnnotation")
    public String testShiroAnnotation(HttpSession session){
        session.setAttribute("key", "value123456");
        shiroService.testMethod();
        return "success";
    }


    @RequestMapping("/hello")
    public String hello(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println("username-->"+username);
        System.out.println("password---->"+password);
        Subject currentUser = SecurityUtils.getSubject();

        // let's login the current user so we can check against roles and permissions:
        // 测试当前的用户是否已经被认证. 即是否已经登录.
        // 调动 Subject 的 isAuthenticated()
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            System.out.println(token.hashCode());
            try {
                // 执行登录.
                currentUser.login(token);

            }
            // 所有认证时异常的父类.
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
                System.out.println("登录失败"+ae.getMessage());
            }
        }
        return "list";
    }

}
