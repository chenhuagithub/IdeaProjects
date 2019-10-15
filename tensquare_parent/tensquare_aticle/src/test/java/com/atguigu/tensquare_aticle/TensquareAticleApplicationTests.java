package com.atguigu.tensquare_aticle;

import com.atguigu.tensquare_aticle.bean.Article;
import com.atguigu.tensquare_aticle.dao.ArticleMapper;
import com.atguigu.tensquare_aticle.service.ArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TensquareAticleApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void contextLoads() {

        articleService.updateState("1");
        articleService.addThumbup("1");
        articleService.updateState("1");
        articleService.addThumbup("1");

    }


    @Autowired
    private ArticleMapper articleMapper;

//    @Test
//    public void test2(){
//        List <Article> all = articleMapper.findAll();
//        System.out.println(all);
//        System.out.println("+++++++++++++++++++++++++");
//        List<Article> all1 = articleMapper.findAll();
//        System.out.println(all1);
//    }
//
    @Test
    public void test3(){
        articleService.findAll("1");
    }

}
