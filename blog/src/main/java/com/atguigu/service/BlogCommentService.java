package com.atguigu.service;

import com.atguigu.bean.BlogComment;
import com.atguigu.dao.BlogCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCommentService {

    @Autowired
    BlogCommentMapper blogCommentMapper;

    public void addComment(BlogComment blogComment){
        blogCommentMapper.addComment(blogComment);
    }


    public List<BlogComment> getBlogComment(Integer blogId){
        return blogCommentMapper.getBlogComment(blogId);
    }

}
