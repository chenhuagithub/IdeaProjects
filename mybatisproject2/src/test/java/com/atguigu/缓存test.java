package com.atguigu;

import com.atguigu.bean.Employee;
import com.atguigu.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class 缓存test {

    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee byIdDis01 = mapper.getByIdDis(2);
            System.out.println("byIdDis01 = " + byIdDis01);
            sqlSession.close();
            EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
            Employee byIdDis = mapper1.getByIdDis(2);
            System.out.println("byIdDis = " + byIdDis);
//            s qlSession.clearCache();
        }finally {
            sqlSession1.close();
        }
    }



    @Test
    public void test02() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee byIdDis1 = mapper.getByIdDis(1);
            System.out.println("byIdDis1 = " + byIdDis1);
            Employee byIdDis2 = mapper.getByIdDis(1);
            System.out.println("byIdDis2 = " + byIdDis2);

        }finally {
            sqlSession.close();
        }
    }
}
