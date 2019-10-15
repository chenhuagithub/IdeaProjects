package com.atguigu.tensquare_recruit.controller;

import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import com.atguigu.tensquare_recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;


    // 热门职位
    @GetMapping("/search/hostlist")
    public Result hotList(){
        return new Result(true, StatusCode.OK, "热门数据查询成功", enterpriseService.hotList("1"));
    }



}
