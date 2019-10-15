package com.atguigu.dao;

import com.atguigu.bean.BlogComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogCommentMapper {


    // 评论
    public void addComment(BlogComment blogComment);


    // 获取文章评论
    public List<BlogComment> getBlogComment(Integer blogId);


    // 获取评论数量
    public List<BlogComment> getCommentCount(@Param("id") Integer id, @Param("state") Integer state);




}
