package com.atguigu.service;

import com.atguigu.bean.BlogReply;
import com.atguigu.dao.BlogReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogReplyService {

    @Autowired
    BlogReplyMapper blogReplyMapper;

    public void addBlogReply(BlogReply blogReply){

        blogReplyMapper.addBlogReply(blogReply);
    }


    public List<BlogReply> findBlogReply(Integer commentId){
        return blogReplyMapper.findBlogReply(commentId);
    }

}
