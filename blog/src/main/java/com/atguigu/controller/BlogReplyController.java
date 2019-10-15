package com.atguigu.controller;

import com.atguigu.bean.BlogReply;
import com.atguigu.service.BlogReplyService;
import com.atguigu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blogReply")
public class BlogReplyController {

    @Autowired
    BlogReplyService blogReplyService;



    @ResponseBody
    @RequestMapping("/addBlogReply")
    public ResponseResult addBlogReply(BlogReply blogReply){
        System.out.println("===================");
        System.out.println(blogReply);
        System.out.println("=====================");
        blogReplyService.addBlogReply(blogReply);
        return new ResponseResult(200, "数据插入成功", null);
    }


    @ResponseBody
    @RequestMapping("/findBlogReply")
    public ResponseResult findBlogReply(Integer commentId){
        List<BlogReply> blogReply = blogReplyService.findBlogReply(commentId);
        System.out.println("==================");
        System.out.println(commentId);
        System.out.println(blogReply);
        System.out.println("===================");
        return new ResponseResult(200, "数据查询成功", blogReply);
    }

}
