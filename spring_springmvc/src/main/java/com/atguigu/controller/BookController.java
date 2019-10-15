package com.atguigu.controller;

import com.atguigu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {


    @Autowired
    BookService bookService;

    public BookController(){
        System.out.println("BookController被创建");
    }


    @RequestMapping("/hello")
    public String hello(){
        System.out.println(bookService);
        return "forward:/WEB-INF/pages/success.jsp";
    }



}
