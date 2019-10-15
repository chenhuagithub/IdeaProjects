package com.atguigu;

import com.atguitu.Imp.MyMathCalculator;
import com.atguitu.inter.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = "classpath:aop.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class aopTest {

//
//    @Autowired
//    Calculator calculator;
//
//    @Test
//    public void test02(){
//        calculator.add(2,3);
////        calculator.div(2,0);
//
//    }


    @Autowired
    MyMathCalculator myMathCalculator;

    @Test
    public void test03(){
//        ApplicationContext aop = new ClassPathXmlApplicationContext("aop.xml");
//        MyMathCalculator myMathCalculator = aop.getBean("myMathCalculator", MyMathCalculator.class);
//        Integer ret = myMathCalculator.add(2, 4);
//        System.out.println(ret);
        System.out.println(myMathCalculator.add(2,3));
    }



}
