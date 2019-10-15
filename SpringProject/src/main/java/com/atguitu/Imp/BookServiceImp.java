package com.atguitu.Imp;

import com.atguitu.dao.BookDao;
import com.atguitu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp extends BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(){
        System.out.println("BookServiceImp正在调用dao");
        bookDao.saveBook();
    }


}
