package com.atguigu;

import com.atguitu.controller.BookController;
import com.atguitu.dao.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:ioc5.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ioc5Test {

    @Autowired
    BookDao bookDao;

    @Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc5.xml");
        Object bookDao = ioc.getBean("bookDao");
        Object bookDao1 = ioc.getBean("bookDao");
        System.out.println(bookDao == bookDao1);
    }


    @Test
    public void test02(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc5.xml");
        BookController bookController = ioc.getBean(BookController.class);
        bookController.doGet();

    }

    @Test
    public void test03(){
        System.out.println(bookDao);
    }

}
