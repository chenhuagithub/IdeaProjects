package com.atguigu.controller;

import com.atguigu.bean.Blog;
import com.atguigu.bean.Blogger;
import com.atguigu.service.BloggerService;
import com.atguigu.utils.MD5Tool;
import com.atguigu.utils.RandomCode;
import com.atguigu.utils.ResponseResult;
import com.atguigu.utils.VerificationCode;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.regexp.internal.RE;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.apache.ibatis.javassist.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @Autowired
    BloggerService bloggerService;

    @Autowired
    VerificationCode verificationCode;

    @Autowired
    RandomCode randomCode;

    // 注册
    @ResponseBody
    @RequestMapping("/register")
    public ResponseResult<Blogger> register(Blogger blogger, HttpSession httpSession){

        System.out.println("===========================");
        System.out.println(blogger);
        System.out.println("===============================");
        // 判断是否输入手机号并且获取了验证码
        if(blogger.getPhone() == null || blogger.getPhone() == ""){
            return new ResponseResult<>(301, "请先获取验证码", null);
        }else {
            // 获取手机号
            String phone = blogger.getPhone();
            // 获取手机号的验证码
//            String phoneCode = (String) httpSession.getAttribute(phone);
            String phoneCode = "666666";
            // 判断验证码是否正确
            if(blogger.getPhoneCode().equals(phoneCode)){
//                httpSession.removeAttribute(phone);
                //不做处理
            }else {
                return new ResponseResult<>(302, "验证码不正确", null);
            }
        }

        try {
            // 添加用户

            bloggerService.addBlogger(blogger);
        } catch (Exception e) {

            return new ResponseResult<>(300, "用户已存在", null);
        }

        return new ResponseResult(200, "注册成功", null);
    }


    // 登录
    @ResponseBody
    @RequestMapping("/login")
    public ResponseResult<Blogger> login(Blogger blogger, HttpServletResponse response, HttpSession httpSession){

        // 判断是否输入手机号并且获取了验证码
        if(blogger.getPhone() == null || blogger.getPhone() == ""){
            return new ResponseResult<>(301, "请先获取验证码", null);
        }else {
            // 获取手机号
            String phone = blogger.getPhone();
            // 获取手机号的验证码
//            String phoneCode = (String) httpSession.getAttribute(phone);
            String phoneCode = "666666";
            // 判断验证码是否正确
            if(blogger.getPhoneCode().equals(phoneCode)){
                //不做处理
//                httpSession.removeAttribute(phone);
                System.out.println("不做处理");
            }else {
                return new ResponseResult<>(302, "验证码不正确", null);
            }
        }


        try {
            // 有该用户登录, 并且设置cookie
            Blogger bloggerPOJO = bloggerService.selectBlogger(blogger);
            System.out.println("==============");
            System.out.println(bloggerPOJO);
            System.out.println("===============");
            Cookie userNameCookie = new Cookie("userNameId", bloggerPOJO.getId().toString());
            // 设置有效时间
//            userNameCookie.setMaxAge(60*60);
            // 设置作用域
            userNameCookie.setPath("/");
            // 将cookie返回客户端
            response.addCookie(userNameCookie);
            System.out.println(httpSession.getAttribute("userNameId"));
            return new ResponseResult<>(200, "登录成功", null);
        } catch (Exception e) {
            // 没有用户直接返回数据
            return new ResponseResult<>(300, "没有该用户", null);
        }

    }


    @ResponseBody
    @RequestMapping("/updateBloggerInfo")
    public ResponseResult updateBloggerInfo(Blogger blogger, @CookieValue("userNameId")String userNameId){

        System.out.println("==================");
        System.out.println(blogger);
        System.out.println(userNameId);
        System.out.println("==================");
        blogger.setId(Integer.parseInt(userNameId));
        System.out.println(blogger);
        bloggerService.updateBloggerInfo(blogger);
        return new ResponseResult(200, "信息修改成功", null);
    }


    @ResponseBody
    @RequestMapping("/uploadImage")
    public ResponseResult uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id){
        System.out.println("文件参数的名字--->"+file.getName());
        System.out.println("图片的名字--->"+file.getOriginalFilename());
        System.out.println("id-->"+id);
        System.out.println("===================================");

        // 根路径
        String basePath = "/home/chenhua/image/";

        //文件路径
        String imageName = file.getOriginalFilename();

        // 访问路径
        String tomcatPath = "http://localhost:8080/image/";

        //文件保存
        try {
            file.transferTo(new File(basePath+file.getOriginalFilename()));
            bloggerService.uploadImage(tomcatPath+imageName, id);
            return new ResponseResult(200, "文件上传成功", null);
        } catch (IOException e) {
            return new ResponseResult(300, "文件上传失败", null);
        }

    }

    @ResponseBody
    @RequestMapping("/findBlogerById")
    public ResponseResult findBlogerById(@CookieValue("userNameId") String id){
        System.out.println("id---->"+id);
        Blogger bloger = bloggerService.findBlogerById(Integer.parseInt(id));

        return new ResponseResult(200, "数据获取成功", bloger);
    }



    // 发送验证码
    @ResponseBody
    @RequestMapping("/sendPhone")
    public ResponseResult sendPhone(@RequestParam("phone") String phone, HttpSession httpSession){
        String code = randomCode.getRandomCode();
        System.out.println("=================");
        System.out.println("code--->"+code);
        System.out.println("===================");
        // 保存验证码在session中, 用于登录注册的时候用
        httpSession.setAttribute(phone, code);
        // 发送验证码
        verificationCode.SingleSend(phone, code);
        System.out.println(httpSession.getAttribute(phone));

        return new ResponseResult(200, "消息发送成功", null);
    }

    /*
            bloggerId: this.getCookie("userNameId"),
            oldPassword: this.oldPassword,
            newPassword: this.newPassword,
            newPasswordAgain: this.newPasswordAgain
     */


    @Autowired
    MD5Tool md5Tool;

    //修改密码
    @ResponseBody
    @RequestMapping("/passwordChange")
    public ResponseResult passwordChange(Integer bloggerId, String oldPassword, String newPassword, String newPasswordAgain){
        System.out.println("=======================");
        System.out.println(bloggerId);
        System.out.println(oldPassword);
        System.out.println(newPassword);
        System.out.println(newPasswordAgain);
        System.out.println("===========================");

        // 判断两次新密码是否一致
        if(newPassword.equals(newPasswordAgain)){
            // 根据id获取博主名字
            Blogger bloger = bloggerService.findBlogerById(bloggerId);

            // 获取前端的密码跟数据库中的密码比对
            String md5Code = md5Tool.getMD5Code("MD5", oldPassword, bloger.getUserName(), 1024);
            if(md5Code.equals(bloger.getPassword())){
                // 加密新密码
                String newPasswordMD5Code = md5Tool.getMD5Code("MD5", newPassword, bloger.getUserName(), 1024);
                // 修改密码
                bloggerService.changePassword(bloggerId, newPasswordMD5Code);

                return new ResponseResult(200, "密码修改成功", null);
            }else {
                return new ResponseResult(300, "旧密码错误", null);
            }
        }else {
            return new ResponseResult(301, "两次新密码输入错误", null);
        }


    }

    @ResponseBody
    @RequestMapping("/findAllInfo")
    public ResponseResult findAllInfo(@RequestParam("id") Integer id){
        Blogger allInfo = bloggerService.findAllInfo(id);
        return new ResponseResult(200, "信息查询成功", allInfo);
    }

    @ResponseBody
    @RequestMapping("/quit")
    public ResponseResult quit(@CookieValue("userNameId")String UserNameId, HttpSession httpSession, HttpServletResponse response){

        Cookie userNameCookie = new Cookie("userNameId", UserNameId);
        // 设置有效时间
        userNameCookie.setMaxAge(1);
        // 设置作用域
        userNameCookie.setPath("/");
        // 将cookie返回客户端
        response.addCookie(userNameCookie);

        System.out.println("=============================");
        return new ResponseResult(200, "成功退出", null);
    }

}

