package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/getpa")
public class GetParamter {

    /**
     * @RequestParam:
     *
     *
     * @RequestHeader:
     *
     *
     * @CookieValue:
     *
     *
     */


    // 获取username参数的值, 变量必须和前端的变量一致
    // http://localhost:8000/myspringmvc_war_exploded/getpa/info?username=chenhua
    @RequestMapping("/info")
    public String test(String username){
        System.out.println("请求参数---->"+username);
        return "success";
    }


    /**
     *
     * @RequestParam:
     *      @RequestParam("user") String username == username = request.getParameter("user")
     *   参数:
     *      value: 指定要获取参数的key
     *      required: 这个参数是否必须有
     *      defaultValue: 默认值, 没带默认值是null
     */
    @RequestMapping("/info2")
    public String test2(@RequestParam(value = "user", required = false, defaultValue = "chenhua") String username){
        System.out.println("请求参数------>"+username);
        return "success";
    }


    /**
     * @RequestHeader: 获取请求头中的key
     *      @RequestHeader("User-Agent") String hearkey == hearkey = request.getHeader("User-Agent")
     *
     *   参数:
     *      value: 指定要获取参数的key
     *      required: 这个参数是否必须有
     *      defaultValue: 默认值, 没带默认值是null
     */
    @RequestMapping("/info3")
    public String test3(@RequestHeader("User-Agent") String hearkey){
        System.out.println("请求头中的User-Agent----->"+hearkey);
        return "success";
    }


    /**
     * @CookieValue(): 获取cookie值
     *
     *   参数:
     *      value: 指定要获取参数的key
     *      required: 这个参数是否必须有
     *      defaultValue: 默认值, 没带默认值是null
     */

    @RequestMapping("/info4")
    public String test4(@CookieValue("JSESSIONID") String cookievalue){
        System.out.println("cookie的值--------->"+cookievalue);
        return "success";
    }

}
