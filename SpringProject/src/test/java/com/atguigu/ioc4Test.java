package com.atguigu;

import com.atguitu.bean.Car;
import com.atguitu.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ioc4Test {


    @Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc4.xml");
        Person person = ioc.getBean("person", Person.class);
        System.out.println("person = " + person);
        System.out.println("car--->"+person.getCar());
        System.out.println("book-->"+person.getBook());
    }


}
