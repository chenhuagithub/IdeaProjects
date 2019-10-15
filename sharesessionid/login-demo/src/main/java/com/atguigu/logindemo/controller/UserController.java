package com.atguigu.logindemo.controller;


import com.atguigu.logindemo.bean.User;
import com.atguigu.logindemo.service.UserService;
import com.atguigu.logindemo.utils.MD5Tool;
import com.atguigu.logindemo.utils.Result;
import com.atguigu.logindemo.utils.StatusCode;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @Autowired
    private MD5Tool md5Tool;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/tologin")
    public String tologin(){
        return "login";
    }


    @GetMapping("/toregister")
    public String toregister(){
        return "register";
    }

    @ResponseBody
    @GetMapping("/noAuth")
    public Result noAuth(){
        return new Result(StatusCode.ERROR, "没有访问权限");
    }

    @ResponseBody
    @PostMapping("/register")
    public Result register(User user){

        try {
            userService.insertUser(user);
            return new Result(StatusCode.OK, "注册成功");
        }catch (Exception e){
            return new Result(StatusCode.ERROR, "该帐号已存在, 请直接登录");
        }

    }


    @ResponseBody
    @PostMapping("/login")
    public Result login(User user){

        user.setPassword(md5Tool.getMD5Code("MD5", user.getPassword(), user.getUsername(), 32));
        // 获取subject
        Subject subject = SecurityUtils.getSubject();

        // 将数据传递给shiro
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        try {
            subject.login(token);
            return new Result(StatusCode.OK, "登录成功");
        }catch (UnknownAccountException e){
            return new Result(StatusCode.ERROR, "用户名不存在");
        }catch (IncorrectCredentialsException e){
            return new Result(StatusCode.ERROR, "密码错误");
        }

    }


    @ResponseBody
    @GetMapping("/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result(StatusCode.OK, "注销成功");
    }


    @ResponseBody
    @GetMapping("/add")
    public Result add(){
        return new Result(StatusCode.OK, "执行添加功能");
    }

    @ResponseBody
    @GetMapping("/update")
    public Result update(){
        return new Result(StatusCode.OK, "执行更新功能");
    }


    @ResponseBody
    @GetMapping("/select")
    public Result select(){
        return new Result(StatusCode.OK, "执行查询功能");
    }


}
