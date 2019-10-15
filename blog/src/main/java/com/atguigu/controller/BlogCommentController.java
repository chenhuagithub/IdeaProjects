package com.atguigu.controller;


import com.atguigu.bean.BlogComment;
import com.atguigu.service.BlogCommentService;
import com.atguigu.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blogComment")
public class BlogCommentController {


    @Autowired
    BlogCommentService blogCommentService;

    @ResponseBody
    @RequestMapping("/addComment")
    public ResponseResult addComment(BlogComment blogComment){
        System.out.println("======================");
        System.out.println(blogComment);
        System.out.println("======================");
        blogCommentService.addComment(blogComment);
        return new ResponseResult(200, "评论成功", null);
    }



    @ResponseBody
    @RequestMapping("/getBlogComment")
    public ResponseResult getBlogComment(@RequestParam("blogId") Integer blogId){
        System.out.println("====================");
        System.out.println(blogId);

        System.out.println("=====================");
        List<BlogComment> blogComment = blogCommentService.getBlogComment(blogId);
        System.out.println("==========================");
        System.out.println(blogComment);
        System.out.println("===============================");
        return new ResponseResult(200, "数据返回成功", blogComment);
    }


}
