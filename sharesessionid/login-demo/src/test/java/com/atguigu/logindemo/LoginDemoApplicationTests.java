package com.atguigu.logindemo;

import com.atguigu.logindemo.bean.Authorization;
import com.atguigu.logindemo.bean.User;
import com.atguigu.logindemo.dao.AuthorizationMapper;
import com.atguigu.logindemo.dao.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthorizationMapper authorizationMapper;


    @Test
    public void test1(){
        Authorization perms = authorizationMapper.findPerms("zhangsan");
        System.out.println(perms.getUser().getUsername());
        System.out.println(perms.getPermissions().getRole());

    }

    @Test
    public void contextLoads() {

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", "djfj"));
        System.out.println(user);

    }

}
