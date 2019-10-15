package com.atguigu.service;

import com.atguigu.bean.Blogger;
import com.atguigu.dao.BloggerMapper;
import com.atguigu.utils.MD5Tool;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BloggerService {

    @Autowired
    BloggerMapper bloggerMapper;

    @Autowired
    MD5Tool md5Tool;

    // 添加用户
    @Transactional
    public void addBlogger(Blogger blogger) throws Exception {
        // 查询数据库中是否有该用户
        Blogger bloggerPOJO = bloggerMapper.selectBlogger(blogger.getUserName());
        if(bloggerPOJO == null){
            String md5Code = md5Tool.getMD5Code("MD5", blogger.getPassword(), blogger.getUserName(), 1024);
            blogger.setPassword(md5Code);
            bloggerMapper.addBlogger(blogger);
        }else {
            throw new Exception("该用户已经存在");
        }

    }


    //查询是否有该用户
    public Blogger selectBlogger(Blogger blogger) throws Exception {
        Blogger bloggerPOJO = bloggerMapper.selectBlogger(blogger.getUserName());
        if(bloggerPOJO != null){
            // 创建一个用户
            Subject currentUser = SecurityUtils.getSubject();
            // 测试当前的用户是否已经被认证. 即是否已经登录.
            // 调动 Subject 的 isAuthenticated()
            if (!currentUser.isAuthenticated()) {
                // 把用户名和密码封装为 UsernamePasswordToken 对象
                UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), blogger.getPassword());
                // rememberme
                token.setRememberMe(true);
                System.out.println(token.hashCode());
                try {
                    // 执行登录.
                    currentUser.login(token);

                }
                // 所有认证时异常的父类.
                catch (AuthenticationException ae) {
                    //unexpected condition?  error?
                    System.out.println("登录失败"+ae.getMessage());
                    throw new Exception("登录失败"+ae.getMessage());
                }
            }
            return bloggerPOJO;
        }else {
            throw new Exception("没有该用户");
        }
    }

    // 修改个人信息
    public void updateBloggerInfo(Blogger blogger){
        bloggerMapper.updateBloggerInfo(blogger);
    }


    // 查询信息
    public Blogger findBlogerById(Integer id){
        return bloggerMapper.findBlogerById(id);
    }



    public void uploadImage(String imageName, Integer id){
        bloggerMapper.uploadImage(imageName, id);
    }


    // 修改密码
    public void changePassword(Integer id, String oldPassword){
        bloggerMapper.changePassword(id, oldPassword);
    }


    public Blogger findAllInfo(Integer id){
        return bloggerMapper.findAllInfo(id);
    }

}
