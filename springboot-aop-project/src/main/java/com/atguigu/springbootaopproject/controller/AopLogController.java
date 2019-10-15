package com.atguigu.springbootaopproject.controller;

import com.atguigu.springbootaopproject.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenhua
 */

@RestController
@RequestMapping("/log")
public class AopLogController {

    @GetMapping
    public Result hello() {
        System.out.println("hello执行了~");
//        int x = 1/0;
        return new Result(200, "成功了", null);
    }

}
