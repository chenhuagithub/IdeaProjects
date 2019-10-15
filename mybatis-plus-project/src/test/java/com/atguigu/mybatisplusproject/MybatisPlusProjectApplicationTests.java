package com.atguigu.mybatisplusproject;

import com.atguigu.mybatisplusproject.bean.Employee;
import com.atguigu.mybatisplusproject.bean.User;
import com.atguigu.mybatisplusproject.dao.EmployeeMapper;
import com.atguigu.mybatisplusproject.dao.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.session.RowBounds;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusProjectApplicationTests {


    @Autowired
    UserMapper userMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {

        List<User> users = userMapper.selectList(null);

        Assert.assertEquals(5, users.size());
        users.forEach(System.out::println);

    }

    // 插入数据
    @Test
    public void test1(){
        User user = new User(6 ,"张三", 12, "111111@qq.com");
        userMapper.insert(user);
    }

    // 删除数据
    @Test
    public void test2(){
         userMapper.deleteById(6);
    }

    @Test
    public void test3(){
        List<Employee> employees = employeeMapper.selectList(null);
        System.out.println(employees);
    }

    @Test
    public void test4(){
        Employee employee = new Employee(5, "陈华", "1111112@qq.com", 1, 23);
        employeeMapper.insert(employee);
    }

    @Test
    public void test5(){
        Employee employee = new Employee();
        employee.setLastName("李四");
//        employee.setEmail("2222@qq.com");
//        employee.setGender(1);
        employee.setAge(43);
        employeeMapper.insert(employee);

        System.out.println("============");
        System.out.println(employee.getId());
    }

    @Test
    public void test6(){
        Employee employee = new Employee();
        employee.setId(6);
        employee.setLastName("李四修改");
        employee.setEmail("2222@qq.com修改");
        employee.setGender(1);
        employee.setAge(43);
        employeeMapper.updateById(employee);
    }


    @Test
    public void test7(){
//Employee employee =employeeMapper.selectOne(new QueryWrapper<Employee>().eq("id","1"));
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<>();
        employeeQueryWrapper.eq("email", "1111112@qq.com");
        employeeQueryWrapper.eq("last_name", "陈华");
        Employee employee = employeeMapper.selectOne(employeeQueryWrapper);
        System.out.println(employee);
//        Employee employee = new Employee();
//        employee.setId(5);
//        employee.setLastName("陈华");
//        Employee employee1 = employeeMapper.selectOne(employee);
//        System.out.println(employee1);
    }

    @Test
    public void test8(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(5);
        List<Employee> employees = employeeMapper.selectBatchIds(integers);
        System.out.println(employees);

    }


    @Test
    public void test9(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("last_name", "陈华");
        hashMap.put("email", "1111112@qq.com");
        List<Employee> employees = employeeMapper.selectByMap(hashMap);
        System.out.println(employees);
    }


    @Test
    public void test10(){
        IPage<Employee> age = employeeMapper.selectPage(new Page<Employee>(2, 2), new QueryWrapper<Employee>().between("age", 12, 40).eq("gender", 1).eq("last_name", "Tom"));
        System.out.println("====================");
        System.out.println(age.getTotal());
        System.out.println(age.getRecords());


    }

    @Test
    public void test11(){
        employeeMapper.delete(new QueryWrapper<Employee>().eq("last_name", "Tom").eq("age", 12));
    }


    @Test
    public void test12(){
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>().between("age", 12, 40).orderBy(true, false, "age"));
        System.out.println(employees);
    }



}
