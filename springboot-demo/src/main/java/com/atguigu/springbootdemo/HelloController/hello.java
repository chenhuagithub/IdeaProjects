package com.atguigu.springbootdemo.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class hello {

//    @RequestMapping("/user/login")
//    @ResponseBody
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession httpSession){
        System.out.println(username);
        System.out.println(password);
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            httpSession.setAttribute("loginUser", username);
            return "welcome";
        }else {
            return "redirect:/login";
        }

    }



}


