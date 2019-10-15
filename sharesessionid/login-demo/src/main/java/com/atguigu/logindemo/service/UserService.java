package com.atguigu.logindemo.service;


import com.atguigu.logindemo.bean.Authorization;
import com.atguigu.logindemo.bean.User;
import com.atguigu.logindemo.dao.AuthorizationMapper;
import com.atguigu.logindemo.dao.UserMapper;
import com.atguigu.logindemo.utils.IdWorker;
import com.atguigu.logindemo.utils.MD5Tool;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthorizationMapper authorizationMapper;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MD5Tool md5Tool;

    // 开启事务
    @Transactional
    public void insertUser(User user) {
        // 查询数据库是否有该用户

        List<User> username = userMapper.selectList(new QueryWrapper<User>().eq("username", user.getUsername()));
        System.out.println("====="+username);
        if(username.size() > 0){
            throw new RuntimeException("用户已存在,请直接登录");
        }
         user.setId(idWorker.nextId()+"");
        String md5Code = md5Tool.getMD5Code("MD5", user.getPassword(), user.getUsername(), 32);
        user.setPassword(md5Code);
        userMapper.insert(user);

        authorizationMapper.insert(new Authorization(idWorker.nextId()+"", user.getId(),"2"));
    }


    public User findByUsername(String username){

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
        return user;
    }






}
