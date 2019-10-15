package com.atguigu.shiroproject;

import com.atguigu.shiroproject.bean.User;
import com.atguigu.shiroproject.dao.UserMapper;
import com.atguigu.shiroproject.utils.IdWorker;
import com.atguigu.shiroproject.utils.MD5Tool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroProjectApplicationTests {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MD5Tool md5Tool;

    @Test
    public void test1(){
        String md5Code = md5Tool.getMD5Code("MD5", "chenhua", "zhongguo", 32);
        System.out.println(md5Code);
    }

    @Test
    public void contextLoads() {
        String md5Code = md5Tool.getMD5Code("MD5", "huazai", "huazai", 32);
        userMapper.insert(new User(idWorker.nextId()+"", "huazai", md5Code, "user:update"));


    }




}
