package com.atguigu.dao;

import com.atguigu.bean.BlogType;

import java.util.List;
import java.util.Map;

public interface BlogTpyeMapper {

    // 查询博客类型列表
    public List<BlogType> countList();

    // 根据id查询一条博客类型
    public BlogType findById(Integer id);

    // 不固定参数查询博客类型列表
    public List<BlogType> BlogTpyeList(Map<String, Object> map);

    // 不固定参数查询博客类型数
    public Long getTotal(Map<String, Object> map);


    // 添加一条博客类型
    public Integer addBlogType(BlogType blogType);

    // 修改一条博客类型
    public Integer update(BlogType blogType);

    // 删除一条博客类型
    public Integer deleteBlogType(BlogType blogType);

    public BlogType findBlogTypeByName(String typeName);



}
