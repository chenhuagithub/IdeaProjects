package com.atguigu;

import com.atguitu.bean.Animal;
import com.atguitu.bean.Car;
import com.atguitu.bean.Person;
import com.atguitu.bean.Sheep;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import javax.xml.transform.Source;

public class MyTest {


    @Test
    public void test99(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

        Sheep sheep = (Sheep) ioc.getBean("sheep");
        System.out.println(sheep);

    }


    @Test
    public void test01(){
        //ApplicationContext: 代表ioc容器
        //ClassPathXmlApplicationContext: 当前应用的xml配置文件在类路径下
        //根据spring的配置文件得到ioc容器对象
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = (Person)ioc.getBean("person");
        System.out.println("person = " + person);

    }

    @Test
    public void test02(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = ioc.getBean("person2",Person.class);
        System.out.println("person = " + person);

    }


    @Test
    public void test03(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person3 = ioc.getBean("person3", Person.class);
        System.out.println("person3 = " + person3);
    }


    @Test
    public void test04(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person person4 = ioc.getBean("person4", Person.class);
        System.out.println("person4 = " + person4);
    }


    @Test
    public void test05(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person = ioc.getBean("person", Person.class);
        System.out.println("person = " + person);
        System.out.println(person.getLastName()==null);
    }


    @Test
    public void test06(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person2 = ioc.getBean("person2", Person.class);
        System.out.println("person2 = " + person2);
        System.out.println(person2.getCar());
        Car car = ioc.getBean("car", Car.class);
        car.setCarName("法拉迪");
        System.out.println("car---->"+car.getCarName());
        System.out.println("person---->"+person2.getCar().getCarName());
        System.out.println(car == person2.getCar());

    }


    @Test
    public void test07(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person3 = ioc.getBean("person3", Person.class);
        System.out.println("person3 = " + person3);
        System.out.println(person3.getCar());
    }


    @Test
    public void test08(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person4 = ioc.getBean("person4", Person.class);
        System.out.println("person4 = " + person4);
        System.out.println(person4.getBook());
    }


    @Test
    public void test09(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person4 = ioc.getBean("person4", Person.class);
        System.out.println("person4 = " + person4);
        System.out.println(person4.getBook());
        System.out.println(person4.getMaps());
        System.out.println(person4.getProperties());
    }


    @Test
    public void test10(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person5 = ioc.getBean("person5", Person.class);
        System.out.println(person5.getMaps());
        System.out.println(person5.getBook());
    }



    @Test
    public void test11(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person7 = ioc.getBean("person7", Person.class);
        System.out.println("person7 = " + person7);
    }


    @Test
    public void test12(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");
        Person person6 = ioc.getBean("person6", Person.class);
        System.out.println("person6 = " + person6);
    }


    @Test
    public void test13(){
        // 加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        // 从Spring容器中获取Animal实例
        Animal animal = applicationContext.getBean("animal", Animal.class);
        System.out.println(animal);
    }

}
