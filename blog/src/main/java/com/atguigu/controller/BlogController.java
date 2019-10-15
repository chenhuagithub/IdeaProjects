package com.atguigu.controller;

import com.atguigu.bean.Blog;
import com.atguigu.service.BlogService;
import com.atguigu.utils.ResponseResult;
import com.atguigu.utils.ResponseResultPlus;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    BlogService blogService;

    @ResponseBody
    @RequestMapping("/addBlog")
    public ResponseResult addBlog(Blog blog){
        System.out.println("====================");
        System.out.println("我来了");
        System.out.println(blog);
        System.out.println("=====================");
        // 插入博客
        blogService.addBlog(blog);
//        return "success";
        return new ResponseResult(200, "博客插入成功", null);

    }


    //查询所有博客数据
    @ResponseBody
    @RequestMapping("/findAllBlog")
    public ResponseResultPlus findAllBlog(@RequestParam(value = "page",required = false, defaultValue = "1") Integer page, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        System.out.println("page====>"+page);
        PageHelper.startPage(page, pageSize);
        List<Blog> blog = blogService.findAllBlog();
        PageInfo<Blog> blogPageInfo = new PageInfo<>(blog);
        // 返回总页数, 当前页,
        List<Integer> info = new ArrayList<>();
        // 当前页
        info.add(blogPageInfo.getPageNum());
        // 总页数
        info.add(blogPageInfo.getPages());
        return new ResponseResultPlus(200, "博客数据返回成功",blogPageInfo.getList(), info);
    }


    @ResponseBody
    @RequestMapping("/findAllBlogByTitle")
    public ResponseResultPlus findAllBlogByTitle(@RequestParam("title") String title,@RequestParam("page") Integer page){
        System.out.println("page-->"+page);
        System.out.println("title--->"+title);
        title = "%"+title+"%";
        PageHelper.startPage(page, 10);
        List<Blog> allBlogByTitle = blogService.findAllBlogByTitle(title);
        PageInfo<Blog> blogPageInfo = new PageInfo<>(allBlogByTitle);

        List<Integer> info = new ArrayList<>();
        info.add(blogPageInfo.getPageNum());
        info.add(blogPageInfo.getPages());

        return new ResponseResultPlus(200, "查询成功", blogPageInfo.getList(), info);
    }


    @ResponseBody
    @RequestMapping("/findBlogById")
    public ResponseResult findBlogById(@RequestParam("id") Integer id){
        System.out.println("id--->"+id);
        //查询一个博客信息
        Blog blog = blogService.findBlogById(id);
        System.out.println(blog);
        return new ResponseResult(200, "数据获取成功", blog);
    }



    @ResponseBody
    @RequestMapping("/updateBlog")
    public ResponseResult updateBlog(Blog blog){
        System.out.println("blog-->"+blog);
        blogService.updateBlog(blog);
        return new ResponseResult(200, "修改数据成功", null);
    }



    @ResponseBody
    @RequestMapping("/deleteBlog")
    public ResponseResult deleteBlog(@RequestParam("id") Integer id){
        blogService.deleteBlog(id);
        return new ResponseResult(200, "数据删除成功", null);
    }


    @ResponseBody
    @RequestMapping("/findAllBlogByIdCount")
    public ResponseResult<Integer> findAllBlogByIdCount(Integer id){

        Integer allBlogByIdCount = blogService.findAllBlogByIdCount(id);
        return new ResponseResult(200, "数据查询成功", allBlogByIdCount);
    }


}
