package com.atguigu.shiroproject.controller;


import com.atguigu.shiroproject.bean.User;
import com.atguigu.shiroproject.dao.UserMapper;
import com.atguigu.shiroproject.utils.IdWorker;
import com.atguigu.shiroproject.utils.MD5Tool;
import com.atguigu.shiroproject.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
public class ShiroController {

    @Autowired
    private MD5Tool md5Tool;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(){
        return "成功";
    }


//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }

//    @GetMapping("/add")
//    public String add(){
//        return "/user/add";
//    }


//    @GetMapping("/update")
//    public String update(){
//        return "/user/update";
//    }

    @GetMapping("/tologin")
    public String login1(){
        return "login";
    }

//    @GetMapping("/noAuth")
//    public String noAuth(){
//        return "noAuth";
//    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @GetMapping("/add")
    public Result add(){
        return new Result(200, "数据添加成功");
    }

    @ResponseBody
    @GetMapping("/update")
    public Result update(){
        return new Result(200, "数据更新成功");
    }

//    @ResponseBody
//    @GetMapping("/tologin")
//    public Result login(){
//        return new Result(302, "还没登录, 请先登录");
//    }

    @ResponseBody
    @GetMapping("/noAuth")
    public Result noAuth(){
        return new Result(301, "没有权限");
    }


    // 退出登录
    @ResponseBody
    @GetMapping("/logout")
    public Result logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new Result(200, "注销成功");
    }


    @ResponseBody
    @CrossOrigin
    @PostMapping("/login")
    public Result login(String username, String password){
        /**
         * 使用shiro编写认证操作
         */

        System.out.println(username);
        System.out.println(password);
        password = md5Tool.getMD5Code("MD5", username, username, 32);
        System.out.println();

        // 1. 获取Subject
        Subject subject = SecurityUtils.getSubject();

        //2. 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        // 3.执行登录方法
        try {
            subject.login(token);
//            return "index";
            return new Result(200, "登录成功");
        }catch (UnknownAccountException e){
//            model.addAttribute("msg", "用户名不存在");
//            return "login";
            return new Result(300, "用户名不存在");
        }catch (IncorrectCredentialsException e){
//            model.addAttribute("msg", "密码错误");
//            return "login";
            return new Result(300, "密码错误");
        }



    }



    @Autowired
    private IdWorker idWorker;


    @ResponseBody
    @PostMapping("/register")
    public Result register(User user){
        user.setId(idWorker.nextId()+"");
        user.setPassword(md5Tool.getMD5Code("MD5", user.getUsername(), user.getPassword(), 32));
        userMapper.insert(user);
        return new Result(200, "注册成功");
    }






}
