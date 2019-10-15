package com.atguigu;

import com.atguigu.bean.Employee;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Mytest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void test01(){

        Employee oneEmployee = employeeMapper.findOneEmployee(2);
        System.out.println(oneEmployee);


    }

}
