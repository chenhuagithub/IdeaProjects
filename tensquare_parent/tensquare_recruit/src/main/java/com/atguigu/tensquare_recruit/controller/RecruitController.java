package com.atguigu.tensquare_recruit.controller;

import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import com.atguigu.tensquare_recruit.bean.Recruit;
import com.atguigu.tensquare_recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;


    // 推荐职位
    @GetMapping("/search/recommend")
    public Result recommend(){
        List<Recruit> recommend = recruitService.recommend_or_newList(2 + "");
        return new Result(true, StatusCode.OK, "推荐职位信息查询成功", recommend);
    }


    // 新职位
    @GetMapping("/search/newlist")
    public Result newlist(){
        List<Recruit> newList = recruitService.recommend_or_newList(0 + "");
        return new Result(true, StatusCode.OK, "新职位信息查询成功", newList);
    }

}
