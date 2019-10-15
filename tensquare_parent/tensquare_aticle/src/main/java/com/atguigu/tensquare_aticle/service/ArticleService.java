package com.atguigu.tensquare_aticle.service;

import com.atguigu.tensquare_aticle.bean.Article;
import com.atguigu.tensquare_aticle.dao.ArticleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public Article findAll(String id){
        // 从redis中获取数据
        Article article = (Article) redisTemplate.opsForValue().get("article_" + id);
        if(article == null){
            article = articleMapper.findAll(id);
            // 把数据保存到redis缓存中
            redisTemplate.opsForValue().set("article_"+id, article,10,  TimeUnit.SECONDS);
        }
        return article;
    }


    /**
     *
     * @param id 文章id
     */
    public void updateState(String id) {
        articleMapper.updateState(id);
    }

    /**
     *
     * @param id 文章id
     */
    public void addThumbup(String id) {
        articleMapper.addThumbup(id);
    }

    public Article selectAll(String id){
//        Article articles = articleMapper.selectList(new QueryWrapper<Article>().eq("id", id));
        Article article = articleMapper.selectById(id);
        return article;
    }


}
