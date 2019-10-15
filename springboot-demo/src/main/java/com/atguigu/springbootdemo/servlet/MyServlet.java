package com.atguigu.springbootdemo.servlet;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class MyServlet extends HttpServlet {

    // 处理get请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        resp.setContentType("text/html;charset=UTF-8");
        System.out.println("来了老铁");
        resp.getWriter().write("我是 get");
    }

    // 处理post请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.getWriter().write("我是定制Servlet");
    }


}
