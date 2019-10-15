package com.atguigu.service;

import com.atguigu.bean.Blog;
import com.atguigu.dao.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogMapper blogMapper;

    // 添加博客数据
    public void addBlog(Blog blog){
        blogMapper.addBlog(blog);
    }


    // 查询所有博客
    public List<Blog> findAllBlog(){
        return blogMapper.findAllBlog();

    }


    public List<Blog> findAllBlogByTitle(String title){
         return blogMapper.findAllBlogByTitle(title);
    }


    public Blog findBlogById(Integer id){
        return blogMapper.findBlogById(id);
    }


    public void updateBlog(Blog blog){
        blogMapper.updateBlog(blog);
    }


    public void deleteBlog(Integer id){
        blogMapper.deleteBlog(id);
    }


    public Integer findAllBlogByIdCount(Integer id){
        List<Blog> allBlogById = blogMapper.findAllBlogById(id);
        // 统计总数
        Integer count = allBlogById.size();
        return count;
    }


}
