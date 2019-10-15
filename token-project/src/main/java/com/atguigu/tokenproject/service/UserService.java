package com.atguigu.tokenproject.service;


import com.atguigu.tokenproject.bean.User;
import com.atguigu.tokenproject.dao.UserMapper;
import com.atguigu.tokenproject.utils.JwtUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpServletRequest request;

    public void deleteUserByName(String username){

        String header = request.getHeader("Authorization");
        if(header == null || header.equals("")){
            throw new RuntimeException("权限不足");
        }
        if(!header.startsWith("Bearer")){
            throw new  RuntimeException("权限不足");
        }

        String token = header.substring(7);
        System.out.println("===========");
        System.out.println(token);
        System.out.println("=============");

        try {
            Claims claims = jwtUtil.pareJWT(token);
            String roles = (String) claims.get("roles");
            if(roles == null || !roles.equals("admin")){
                throw new RuntimeException("权限不足");
            }
        }catch (Exception e){
            throw new RuntimeException("权限不足");
        }
        userMapper.delete(new QueryWrapper<User>().eq("username", username));
    }


}
