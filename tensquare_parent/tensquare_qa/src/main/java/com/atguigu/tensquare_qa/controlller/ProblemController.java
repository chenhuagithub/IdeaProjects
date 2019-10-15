package com.atguigu.tensquare_qa.controlller;

import com.atguigu.tensquare_common.entity.Result;
import com.atguigu.tensquare_common.entity.StatusCode;
import com.atguigu.tensquare_common.util.IdWorker;
import com.atguigu.tensquare_qa.bean.Problem;
import com.atguigu.tensquare_qa.client.BaseClient;
import com.atguigu.tensquare_qa.dao.ProblemMapper;
import com.atguigu.tensquare_qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;
    
    @Autowired
    private BaseClient baseClient;

    @GetMapping("/label/{labelId}")
    public Result findByLabelId(@PathVariable String labelId){
        Result result = baseClient.findById(labelId);
        return result;

    }


    // 最新回答列表
    @GetMapping("/search/newlist/{labelName}/{page}/{size}")
    public Result newlist(@PathVariable String labelName, @PathVariable Integer page, @PathVariable Integer size){
        List<Problem> problemsList = problemService.newList(labelName, page, size);
        return new Result(true, StatusCode.OK, "最新问题列表", problemsList);
    }

    // 热门回答列表
    @GetMapping("/hostlist/{labelName}/{page}/{size}")
    public Result hostlist(@PathVariable String labelName, @PathVariable Integer page, @PathVariable Integer size){
        List<Problem> problemsList = problemService.hotList(labelName, page, size);
        return new Result(true, StatusCode.OK, "最热门问题列表", problemsList);
    }

    // 等待回答列表
    @GetMapping("/waitlist/{labelName}/{page}/{size}")
    public Result waitlist(@PathVariable String labelName, @PathVariable Integer page, @PathVariable Integer size){
        List<Problem> problemsList = problemService.waitList(labelName, page, size);
        return new Result(true, StatusCode.OK, "最热门问题列表", problemsList);
    }

}
