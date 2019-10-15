package com.atguigu.dao;

import com.atguigu.bean.BlogFocus;

import java.util.List;

public interface BlogFocusMapper {

    // 添加关注
    public void addBlogFocus(BlogFocus blogFocus);

    //查询关注
    public List<BlogFocus> findAllBlogFocus(Integer focusId);


    // 取消关注
    public void deleteBlogFocus(BlogFocus blogFocus);


    // 查看是否已经关注
    public BlogFocus findOneBlogFocus(BlogFocus blogFocus);




}
