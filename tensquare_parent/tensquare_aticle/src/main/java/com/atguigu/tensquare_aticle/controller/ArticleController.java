package com.atguigu.tensquare_aticle.controller;

import com.atguigu.tensquare_aticle.bean.Article;
import com.atguigu.tensquare_aticle.dao.ArticleMapper;
import com.atguigu.tensquare_aticle.service.ArticleService;
import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    ArticleService articleService;

    // 文章审核
    @PutMapping("/examine/{articleId}")
    public Result updateState(@PathVariable String articleId) {
        articleService.updateState(articleId);
        return new Result(true, StatusCode.OK, "文章审核成功");
    }

    // 文章点赞
    @PutMapping("/thumbup/{articleId}")
    public Result addThumbup(@PathVariable String articleId) {
        articleService.addThumbup(articleId);
        return new Result(true, StatusCode.OK, "已点赞");
    }

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
//    private ArticleService articleService;

    @GetMapping("/hello")
    public Result hello(){
        Article all = articleService.findAll("2");
//        articleService.selectAll();
        return new Result(true, StatusCode.OK, "获取数据成功", all);
    }

    @GetMapping("/hi/{id}")
    public Result hi(@PathVariable String id){
        Article article = articleService.selectAll(id);
        return new Result(true, StatusCode.OK, "获取数据成功", article);
    }

}
