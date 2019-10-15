package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/haha")
public class MyFirstController {

    /**
     * @RequestMapping( ) 参数属性
     * 1. value
     *      规定路由
     *
     * 2. method
     *      规定请求方法
     *
     * 3. params
     *      规定请求参数
     *      params = {"username"}: 请求地址必须带username这个参数
     *      params = {"!username"}: 请求地址必须不带username这个参数
     *      params = {"username!=123"}: username这个参数不等于123
     *      params = {"username=123", "pwd", "!age"}: 同时满足三个条件
     *
     *
     * 4. headers
     *      规定请求头, 用法跟params一样
     *      谷歌: User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36
     *      火狐: User-Agent: Mozilla/5.0 (X11; Ubuntu; Linu…) Gecko/20100101 Firefox/67.0
     *
     * 5. consumes
     *      只接受内容类型是哪种的请求, 规定请求头中的Content-Type
     *
     * 6. produces
     *      告诉浏览器返回的内容是什么, 给相应头中加上Content-Type: text/html;charset=utf-8;
     *
     */




    @RequestMapping(value = "/hello", method = RequestMethod.GET, params = {"username"}, headers = {"User-Agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36"})
    public String MyFirst(){

        System.out.println("请求收到了......");

        return "success";
    }

    /**
     * @RequestMapping( ) 模糊匹配功能
     *  URL地址可以写模糊通配符
     *      ?: 能替代任意一个字符
     *      *: 能替代任意多个字符, 和一层路径
     *      **: 能替代多层路径
     *
     */

    @RequestMapping("a?/**/antTest0?")
    public String antTest(){
        System.out.println("请求成功....");
        return "success";
    }


}
