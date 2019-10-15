package com.atguigu;

import com.atguitu.dao.BookDao;
import com.atguitu.service.BookService;
import com.atguitu.service.Userservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.plaf.PanelUI;

@ContextConfiguration(locations = "classpath:ioc5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class danyuanTest {


    @Autowired
    BookDao bookDao;


    @Autowired
    BookService bookService;

    @Autowired
    Userservice userservice;


    @Test
    public void test01(){
        bookDao.saveBook();
    }

    @Test
    public void test02(){
        bookService.save();
        userservice.save();
    }

}
