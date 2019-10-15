package com.atguigu.tensquare_aticle.dao;

import com.atguigu.tensquare_aticle.bean.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {


    public void updateState(String id);

//    @Update("update tb_article set thumbup = thumbup+1 where id = #{id};")
    public void addThumbup(String id);

//    @Select("select * from tb_article")
    public Article findAll(String id);


}
