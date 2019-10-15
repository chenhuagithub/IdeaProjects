package com.atguitu.controller;

import com.atguitu.bean.Book;
import com.atguitu.dao.BookDao;
import com.atguitu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Qualifier("bookService2")
    @Autowired(required = false)
    private BookService bookServiceImp;


    public void doGet(){
        System.out.println("bookServiceImp = " + bookServiceImp);
//        bookServiceImp.save();
    }

    @Autowired
    public void hahaha(BookDao bookDao, BookService bookService){
        System.out.println("Spring运行了这个方法...."+bookDao+"---->"+bookService);
    }



}
