package com.atguigu.tensquare_user.controller;


import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import com.atguigu.tensquare_user.bean.User;
import com.atguigu.tensquare_user.service.UserService;
import com.atguigu.tensquare_user.utils.JwtUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/{userid}")
    public Result findById(@PathVariable String userid){

        User user = userService.findById(userid);
        return new  Result(true, StatusCode.OK,"数据查询成功", user);
    }

    @GetMapping("/delete/{userid}")
    public Result delete(@PathVariable String userid){
        try {
            userService.delete(userid);
            return new Result(true, StatusCode.OK, "删除成功");
        }catch (Exception e){
            return new Result(true, StatusCode.OK, "权限不足");
        }

    }



    @PostMapping("/login")
    public Result login(String mobile, String password){
        System.out.println(mobile);
        System.out.println(password);
        User user = userService.findMobilePassword(mobile, password);
        if(user != null){
            String token = jwtUtil.createJWT(user.getId(), user.getMobile(), "user");
            return new Result(true, StatusCode.OK, "登录成功", token);
        }else {
            return new Result(true, StatusCode.OK, "登录失败");
        }


    }

    @PostMapping("/hello")
    public Result hello(){

        return new Result(true, StatusCode.OK, "你好啊, 我是user");
    }



}
