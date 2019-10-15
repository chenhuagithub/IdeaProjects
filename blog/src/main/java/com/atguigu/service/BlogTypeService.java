package com.atguigu.service;

import com.atguigu.bean.Blog;
import com.atguigu.bean.BlogType;
import com.atguigu.dao.BlogMapper;
import com.atguigu.dao.BlogTpyeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BlogTypeService{


    @Autowired
    BlogTpyeMapper blogTpyeMapper;

    public List<BlogType> countList() {
        List<BlogType> blogTypes = blogTpyeMapper.countList();
        return blogTypes;
    }

    public BlogType findById(Integer id) {
        return null;
    }

    public List<BlogType> BlogTpyeList(Map<String, Object> map) {
        return null;
    }

    public Long getTotal(Map<String, Object> map) {
        return null;
    }

    public Integer addBlogType(BlogType blogType) {
        Integer flag = blogTpyeMapper.addBlogType(blogType);
        return flag;
    }

    public Integer update(BlogType blogType) {
        Integer update = blogTpyeMapper.update(blogType);
        return update;
    }

    @Autowired
    BlogMapper blogMapper;

    @Transactional
    public Integer deleteBlogType(BlogType blogType) throws Exception {

        // 查询博客表看有没有该id
        List<Blog> blogByTypeId = blogMapper.findBlogByTypeId(blogType.getId());
        System.out.println("================================");
        System.out.println("blogTypeByName--->"+blogByTypeId);
        System.out.println(blogByTypeId.size());
        System.out.println("==================================");
        if(blogByTypeId.size()!=0){
            throw new Exception("博客类别下有博客, 不能删除");
        }else {
            Integer integer = blogTpyeMapper.deleteBlogType(blogType);
            return integer;
        }
    }
}
