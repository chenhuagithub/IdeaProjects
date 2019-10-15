package com.atguigu.dao;

import com.atguigu.bean.BlogReply;

import java.util.List;

public interface BlogReplyMapper {


    // 插入回复数据
    public void addBlogReply(BlogReply blogReply);


    // 查询所有回复数据
    public List<BlogReply> findBlogReply(Integer commentId);

}
