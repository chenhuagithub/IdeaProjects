package com.atguigu.controller;

import com.atguigu.bean.BlogFocus;
import com.atguigu.bean.Blogger;
import com.atguigu.service.BlogFocusService;
import com.atguigu.utils.ResponseResult;
import com.atguigu.utils.ResponseResultPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/blogFocus")
public class BlogFocusController {


    @Autowired
    BlogFocusService blogFocusService;

    // 关注
    @ResponseBody
    @RequestMapping("/addBlogFocus")
    public ResponseResult addBlogFocus(BlogFocus blogFocus){
        System.out.println("====================");
        System.out.println(blogFocus.getFocusId());
        System.out.println(blogFocus.getBefocusId());
        System.out.println("=======================");
        blogFocusService.addBlogFocus(blogFocus);
        return new ResponseResult(200, "关注成功", null);
    }



    // 取消关注
    @ResponseBody
    @RequestMapping("/deleteBlogFocus")
    public ResponseResult deleteBlogFocus(BlogFocus blogFocus){

        blogFocusService.deleteBlogFocus(blogFocus);
        return new ResponseResult(200, "取消关注成功", null);
    }


    @ResponseBody
    @RequestMapping("/findOneBlogFocus")
    public ResponseResult findOneBlogFocus(BlogFocus blogFocus){
        System.out.println("++++++++++++++++++++");
        System.out.println(blogFocus);
        System.out.println("++++++++++++++++++++++");
        BlogFocus focus = blogFocusService.findOneBlogFocus(blogFocus);
        System.out.println("----------------------");
        System.out.println(focus);
        System.out.println("------------------------");
        if(focus==null){
            System.out.println("==========================");
            System.out.println("没有数据");
            System.out.println("===========================");
            return new ResponseResult(202, "没有数据", null);
        }else {
            System.out.println("有数据");
            return new ResponseResult(200, "数据查询成功", null);
        }


    }


    // 查看我的关注
    @ResponseBody
    @RequestMapping("/findAllFocus")
    public ResponseResult findAllFocus(@RequestParam("focusId") Integer focusId){

        System.out.println("===============");
        System.out.println(focusId);
        List<Blogger> allFocus = blogFocusService.findAllFocus(focusId);
        System.out.println(allFocus);
        System.out.println("=========================");
        return new ResponseResult(200, "数据查询成功", allFocus);
    }


    @ResponseBody
    @RequestMapping("/findAllBlogFocusCount")
    public ResponseResult findAllBlogFocusCount(Integer id){
        Integer allBlogFocusCount = blogFocusService.findAllBlogFocusCount(id);

        return new ResponseResult(200, "关注人的数量查询成功", allBlogFocusCount);
    }



}
