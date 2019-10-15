package com.atguigu.service;

import com.atguigu.bean.BlogFocus;
import com.atguigu.bean.Blogger;
import com.atguigu.dao.BlogFocusMapper;
import com.atguigu.dao.BloggerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogFocusService {

    @Autowired
    BlogFocusMapper blogFocusMapper;

    @Autowired
    BloggerMapper bloggerMapper;

    public void addBlogFocus(BlogFocus blogFocus) {
        blogFocusMapper.addBlogFocus(blogFocus);
    }


    public Integer findAllBlogFocusCount(Integer focusId) {
        List<BlogFocus> allBlogFocus = blogFocusMapper.findAllBlogFocus(focusId);
        Integer count = allBlogFocus.size();
        return count;
    }


    public void deleteBlogFocus(BlogFocus blogFocus){
        blogFocusMapper.deleteBlogFocus(blogFocus);
    }

    public BlogFocus findOneBlogFocus(BlogFocus blogFocus){
        return blogFocusMapper.findOneBlogFocus(blogFocus);
    }


    public List<Blogger> findAllFocus(Integer focusId){
        List<Blogger> list = new ArrayList<>();
        List<BlogFocus> blogFocus = blogFocusMapper.findAllBlogFocus(focusId);
        for(BlogFocus b : blogFocus){
            Blogger blogger = bloggerMapper.findBlogerById(b.getBefocusId());
            list.add(blogger);
        }
        return list;

    }

}
