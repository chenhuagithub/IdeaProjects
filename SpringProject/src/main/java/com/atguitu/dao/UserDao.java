package com.atguitu.dao;


import com.atguitu.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {


    @Override
    public void save() {
        System.out.println("UserDao....保存用户");
    }
}
