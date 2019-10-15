package com.atguigu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.logging.Handler;

/**
 * @SessionAttributes(value = "")(只能标注在类上)
 *  @SessionAttributes(value = "msg"):
 *      给BindingAwareModelMap中保存的数据, 或者ModelAndView中的数据, 同时给session中放一份,
 *      value指定保存数据时要给seession中放的数据的key
 *
 *      value={"msg","haha"}: 保存msg和haha这两种key时, 给session中也放一份
 *      types={String.class}: 只要保存的是这种类型的数据, 给Session中也放一份
 *
 */

@SessionAttributes(value = "msg")
@Controller
@RequestMapping("/model")
public class modelandviewController {


    @RequestMapping("/view")
    public String Handler01(Map<String, Object>map){
        map.put("msg", "你好");
        return "success";
    }


    @RequestMapping("/view2")
    public String hander02(Model model){
        model.addAttribute("msg", "你好坏");
        return "success";
    }

    @RequestMapping("/view3")
    public String hander03(ModelMap modelMap){
        modelMap.addAttribute("msg", "你是真的皮");
        return "success";
    }

    @RequestMapping("/view4")
    public ModelAndView hander04(){
        // 之前返回值我们就叫视图名, 视图名视图解析器是会帮我们最终拼串得到页面的真实地址
        ModelAndView modelAndView = new ModelAndView("success");
        modelAndView.addObject("msg", "你好哦");
        return modelAndView;
    }

    /**
     *  注意: 有前缀的转发和重定向操作, 配置的视图解析器就不会进行拼串
     *
     *
     *  转发: forward: 转发的路径
     *  重定向: redirect: 重定向的路径
     *      /hello.jsp: 代表就是从当前项目下开始, springmvc会为路径自地拼接上项目名
     *
     *
     *      原生的Servlet的重定向路径需要加上项目名才能成功
     *      response.sendRedirect("/hello.jsp")
     *
     */
    //转发
    @RequestMapping("/view5")
    public String handler05(){
            //视图转发
            return "forward:/WEB-INF/pages/success.jsp";
//        return "../../hello";
    }

    //重定向
    @RequestMapping("/view6")
    public String handler06(){
        return "redirect:/model/view5";
//        return "redirect:/hello.jsp";
    }


}
