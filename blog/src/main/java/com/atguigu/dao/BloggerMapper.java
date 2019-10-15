package com.atguigu.dao;

import com.atguigu.bean.Blog;
import com.atguigu.bean.Blogger;
import org.apache.ibatis.annotations.Param;

import javax.swing.text.View;
import java.util.List;

public interface BloggerMapper {

    //用户注册时候添加用户
   void addBlogger(Blogger blogger);

    // 使用用户名查询用户
    Blogger selectBlogger(String userName);

    // 查询所有用户
    List<Blogger> selectAllBlogger();


    // 修改个人信息
    public void updateBloggerInfo(Blogger blogger);


    // 根据id查询用户名字
    public Blogger findBlogerById(Integer id);


    // 头像上传
    public  void uploadImage(@Param("imageName") String imageName, @Param("id") Integer id);


    // 修改密码
    public void changePassword(@Param("id") Integer id, @Param("oldPassword") String oldPassword);


    //根据id查询个人信息
    public Blogger findAllInfo(Integer id);



}
