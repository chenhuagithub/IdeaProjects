package com.atguigu.swaggerdemo.controller;


import com.atguigu.swaggerdemo.bean.Cat;
import com.atguigu.swaggerdemo.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// 对接口进行说明
@Api(tags = "用户相关请求")
@RestController
@RequestMapping("/user")
public class UserController {

    // 对每个接口方法进行说明
    @ApiOperation("获取用户信息")
    // 对接口参数进行说明
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", defaultValue = "张三"),
            @ApiImplicitParam(name = "age", value = "年龄", defaultValue = "23")
    })
    @GetMapping
    public User getUser(User user){
        return user;
    }

    @ApiOperation("添加用户信息")
    @PostMapping
    public String addUser(String username, HttpSession session, HttpServletRequest httpServletRequest){
        return username;
    }

}
