package com.atguigu.tensquare_user.service;


import com.atguigu.tensquare_user.bean.User;
import com.atguigu.tensquare_user.dao.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpServletRequest request;


    // 根据id查询用户信息
    public User findById(String userid){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("id", userid));
        return user;
    }

    public User findMobilePassword(String mobile, String password){
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("mobile", mobile).eq("password", password));
        if(user == null || user.equals("")){
            return null;
        }
        return user;
    }


    // 根据id删除用户
    public void delete(String userid){
        String token = (String) request.getAttribute("claims_admin");
        if(token == null || token.equals("")){
            throw new RuntimeException("权限不足");
        }
        userMapper.delete(new QueryWrapper<User>().eq("id", userid));
    }




}
