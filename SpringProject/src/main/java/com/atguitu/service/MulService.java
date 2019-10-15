package com.atguitu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MulService {


    @Autowired
    BookService bookService;


    @Transactional
    public void mulTx(){

        bookService.checkout("Tom", "ISBN-002");

        bookService.updatePrice("ISBN-002", 998);

//        int i=1/0;

    }

}
