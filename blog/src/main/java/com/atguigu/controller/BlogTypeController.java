package com.atguigu.controller;


import com.atguigu.bean.BlogType;
import com.atguigu.service.BlogTypeService;
import com.atguigu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.message.Message;

import java.util.List;

@Controller
@RequestMapping("/blogtype")
public class BlogTypeController {

    @Autowired
    BlogTypeService blogTypeService;

    @ResponseBody
    @RequestMapping("/countList")
    public ResponseResult<BlogType> countList(){
        List<BlogType> blogTypes = blogTypeService.countList();
        System.out.println(blogTypes);
        return new ResponseResult(200, "数据返回成功", blogTypes);
    }


    // 添加博客类型
    @ResponseBody
    @RequestMapping("/addBlogType")
    public ResponseResult<Integer> addBlogType(BlogType blogType){
        System.out.println("I come ....");
        Integer integer = blogTypeService.addBlogType(blogType);
        return new ResponseResult<>(200, "数据添加成功", integer);
//        return result;
    }


    // 删除博客类型
    @ResponseBody
    @RequestMapping("/deleteBlogType")
    public ResponseResult<Integer> deleteBlogType(BlogType blogType){
        System.out.println("数据----->"+blogType);

        try {
            Integer integer = blogTypeService.deleteBlogType(blogType);
            return new ResponseResult<>(200, "数据删除成功", integer);
        } catch (Exception e) {
            return new ResponseResult<>(202, "该博客类别下有博客, 不能删除", null);

        }

    }


    //修改博客类型
    @ResponseBody
    @RequestMapping("/updateBlogType")
    public ResponseResult<Integer> updateBlogType(BlogType blogType){
        System.out.println("我来了...");
        System.out.println(blogType);
        Integer update = blogTypeService.update(blogType);
        return new ResponseResult<>(200, "数据修改成功", update);
    }

}
