package com.atguigu.mybatisplusproject;

import com.atguigu.mybatisplusproject.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusProjectApplicationTests2 {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void test1(){

        System.out.println(employeeMapper);


    }


}
