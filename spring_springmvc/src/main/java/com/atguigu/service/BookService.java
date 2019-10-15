package com.atguigu.service;


import com.atguigu.controller.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    public BookService(){
        System.out.println("BookService被创建");
    }

}
