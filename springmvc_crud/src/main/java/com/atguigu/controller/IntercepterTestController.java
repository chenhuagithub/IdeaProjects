package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IntercepterTestController {

    @ResponseBody
    @RequestMapping("/test01")
    public String test01(){
        System.out.println("go to jsp");
        return "success";
    }


    @ResponseBody
    @RequestMapping("/test02")
    public String test02(@RequestParam(value = "page", required = false, defaultValue = "2") Integer page){
        System.out.println(2/page);
        return "success";
    }


    /**
     *  @ExceptionHandler
     *      告诉springmvc这个方法专门处理这个类发生的异常
     *      value: 指定处理异常的种类
     *
     *  注意:
     *      1. 给方法上随便写一个Exception, 用来接受发生的异常
     *      2. 要携带异常信息不能给参数位置写Model
     *      3. 返回ModelAndView就行了
     *      4. 如果有多个@ExceptionHandler都能处理这个异常, 精确优先
     *      5. 全局异常处理与本类他同时存在, 本类优先
     *
     */

//    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
//    public String handleException01(){
//        System.out.println("出错了老铁");
//        return "error";
//
//    }

}


