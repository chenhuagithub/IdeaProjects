package com.atguigu.dao;

import com.atguigu.bean.Blog;

import java.util.List;

public interface BlogMapper {

    // 添加博客
    public void addBlog(Blog blog);


    // 查询博客所有内容
    public List<Blog> findAllBlog();


    // 根据标题查询博客
    public List<Blog> findAllBlogByTitle(String title);


    public Blog findBlogById(Integer id);

    public void updateBlog(Blog blog);

    // 删除博客
    public void deleteBlog(Integer id);

    public List<Blog> findBlogByTypeId(Integer typeId);

    // 根据id查询博客条数
    public List<Blog> findAllBlogById(Integer id);





}
