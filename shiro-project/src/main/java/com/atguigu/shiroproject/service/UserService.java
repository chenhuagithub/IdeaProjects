package com.atguigu.shiroproject.service;


import com.atguigu.shiroproject.bean.User;
import com.atguigu.shiroproject.dao.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User findUser(String username){
        User username1 = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        return username1;
    }

    public void deleteUser(String username){
        userMapper.delete(new QueryWrapper<User>().eq("username", username));
    }



}
