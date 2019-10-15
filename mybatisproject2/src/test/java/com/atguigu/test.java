package com.atguigu;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;
import com.atguigu.dao.EmployeeMapperAnnotation;
import com.atguigu.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Employee employee = sqlSession.selectOne("EmpById", 1);
            System.out.println(employee.getEmail());
            System.out.println(employee.getLastName());
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
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.EmpById(1,"huazai");
        System.out.println(employee.getId());
        System.out.println(employee.getLastName());
        System.out.println(employee.getGender());
        System.out.println(employee.getEmail());
        System.out.println(employee.toString());
    }


    @Test
    public void test03() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
        Employee empById = mapper.getEmpById(1);
        System.out.println(empById.getLastName());
    }


    @Test
    public void test04() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "jerry", "n", "jerry@atguigu.com");
            mapper.addEmp(employee);
            System.out.println(employee.getId());

            //提交数据
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

    }


    @Test
    public void delete_demo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmpById(4);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void update_demo() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(1, "huazai", "nv", "123456@qq.com");
            mapper.updateEmp(employee);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void selectByMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("lastName", "huazai");
            map.put("tablename","tbl_employee");
            Employee employee = mapper.EmpByMap(map);
            System.out.println(employee.getId());
            System.out.println(employee.getLastName());
            System.out.println(employee.getGender());
            System.out.println(employee.getEmail());
        }finally {
            sqlSession.close();
        }
    }

    // 查询结果返回集合
    @Test
    public void returnList() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> je = mapper.selectByLastName("%e%");
            System.out.println(je.getClass());
            for(Employee em : je){
                System.out.println(em.getId()+"  "+em.getLastName()+"  "+em.getGender()+"  "+em.getEmail());
            }

        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectByIdReturnMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> stringObjectMap = mapper.selectByIdReturnMap(1);
            System.out.println(stringObjectMap);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectByIdReturnMoreMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Employee> integerEmployeeMap = mapper.selectByIdReturnMoreMap("%e%");
            System.out.println(integerEmployeeMap);
            Collection<Employee> values = integerEmployeeMap.values();
            System.out.println(values);
            for(Employee e : values){
                System.out.println(e.getId()+"  "+e.getLastName()+"  "+e.getGender()+"  "+e.getEmail());
            }

        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void selectByIdResutlMap() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empByIdMapResult = mapper.getEmpByIdMapResult(1);
            System.out.println(empByIdMapResult.getLastName()+"  "+empByIdMapResult.getGender()+"  "+empByIdMapResult.getEmail());

        }finally {
            sqlSession.close();
        }
    }



    @Test
    public void SelectByIdOnetoManyResultMap() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Map<String, Object> empByIdOneToManyMapResult = mapper.getEmpByIdOneToManyMapResult(1);
            System.out.println("empByIdOneToManyMapResult = " + empByIdOneToManyMapResult);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void SelectByIdOnetoManyResultMap2() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empByIdOneToManyMapResult2 = mapper.getEmpByIdOneToManyMapResult2(3 );
            System.out.println("empByIdOneToManyMapResult2 = " + empByIdOneToManyMapResult2);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test10() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee byId = mapper.getById(1);
//            System.out.println(byId.getLastName());
            System.out.println("byId = " + byId);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test11() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee byId = mapper.getById(3);
            System.out.println(byId.getLastName());
            System.out.println(byId.getDepartment().getDepartmentName());
//            System.out.println("byId = " + byId);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test12() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee byId2 = mapper.getById2(1);
            System.out.println("byId2 = " + byId2);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test13() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department byId3 = mapper.getById3(2);
            System.out.println("byId3 = " + byId3);
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void oneToMany() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department byIdPlus = mapper.getByIdPlus(1);
            System.out.println("byIdPlus = " + byIdPlus);

        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void OneToManyStep() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department byIdStep = mapper.getByIdStep(1);
//            System.out.println("byIdStep = " + byIdStep);
            System.out.println(byIdStep.getDepartmentName());
            System.out.println(byIdStep.getEmployees());
        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void test15() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee byIdDis = mapper.getByIdDis(1);
            System.out.println("byIdDis = " + byIdDis);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test16() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department byId = mapper.getById(1);
            System.out.println("byId = " + byId);

        }finally {
            sqlSession.close();
        }
    }




}
