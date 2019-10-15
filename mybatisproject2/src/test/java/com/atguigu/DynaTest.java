package com.atguigu;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeMapper;
import com.atguigu.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynaTest {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%eyr%", null, null);
            List<Employee> byConditionIf = mapper.getByConditionIf(employee);
            System.out.println("byConditionIf = " + byConditionIf);
        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void test02() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%eyr%", null, null);
            List<Employee> byConditionIf = mapper.getByConditionIf2(employee);
            System.out.println("byConditionIf = " + byConditionIf);
        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void test03() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, null, null, null);
            List<Employee> byChoose = mapper.getByChoose(employee);
            System.out.println("byChoose = " + byChoose);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test04() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "chenhua", "0", null);
            mapper.updateEmp(employee);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test05() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> byIdForeach = mapper.getByIdForeach(Arrays.asList(1, 3));
            System.out.println("byIdForeach = " + byIdForeach);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test06() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null,"smith","1","smith@qq.com",new Department(1)));
            emps.add(new Employee(null,"allen","0","allen@qq.com",new Department(2)));
            mapper.addEmpsForeach(emps);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void test07() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> bylastName = mapper.findBylastName("%a%");
            System.out.println("bylastName = " + bylastName);
        }finally {
            sqlSession.close();
        }
    }


}
