package com.atguigu.tokenproject.controller;


import com.atguigu.tokenproject.service.UserService;
import com.atguigu.tokenproject.utils.JwtUtil;
import com.atguigu.tokenproject.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result login(String username, String password){
        String jwt = jwtUtil.createJWT("111111", "admin", "admin");
        return new Result(200, "登录成功", jwt);
    }

    @GetMapping("/delete")
    public Result delete(String username){
        try {
            userService.deleteUserByName(username);
            return new Result(200, "删除成功");
        }catch (Exception e){
            return new Result(300, "权限不足");
        }
    }
}
