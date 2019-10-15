package com.atguigu.controller;

import com.atguigu.bean.Blogger;
import com.atguigu.bean.User;
import com.atguigu.dao.BloggerMapper;
import com.atguigu.service.BloggerService;
import com.atguigu.utils.ResponseResult;
import com.google.gson.Gson;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class HelloController {

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username", required = false) String username, @RequestParam("file") MultipartFile file){
        System.out.println("文件参数的名字--->"+file.getName());
        System.out.println("图片的名字--->"+file.getOriginalFilename());

        System.out.println("+++++++++++++++++++++++++");
        System.out.println("来了老帖");
        System.out.println("++++++++++++++++++++++===");

        //文件保存
        try {
            file.transferTo(new File("/home/chenhua/文档/upload/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

    }




}
