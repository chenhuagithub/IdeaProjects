package com.atguigu;

import com.atguitu.bean.AirPlane;
import com.atguitu.bean.Person;
import com.atguitu.factory.AirPlaneStaticFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class ioc3test {

    @Test
    public void test01(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        Person person1 = ioc.getBean("person", Person.class);
        Person person2 = ioc.getBean("person", Person.class);
        System.out.println(person1 == person2);
    }


    @Test
    public void test02(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        Object airPlane01 = ioc.getBean("airPlane01");
        System.out.println("airPlane01 = " + airPlane01);
    }

    @Test
    public void test03(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        Object airPlane02 = ioc.getBean("airPlane02");
        System.out.println("airPlane02 = " + airPlane02);
    }


    @Test
    public void test04() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
        DataSource dataSource = ioc.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
