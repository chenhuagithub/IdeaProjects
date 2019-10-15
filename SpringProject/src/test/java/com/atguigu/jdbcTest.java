package com.atguigu;


import com.atguitu.service.BookService;
import com.atguitu.service.MulService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = "classpath:myjdbc.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class jdbcTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void test(){
        System.out.println(dataSource);
    }


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test02(){
        String sql = "update tbl_employee set last_name=? where id=?";
        int update = jdbcTemplate.update(sql, "chenyongjie", 3);
        System.out.println(update);

    }


    @Test
    public void test03(){
        String sql = "insert into tbl_employee(last_name, gender, email) values (?, ?, ?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"zhangsan","1", "827483@qq.com"});
        list.add(new Object[]{"lisi", "0", "40909@qq.com"});
        int[] ints = jdbcTemplate.batchUpdate(sql, list);
        for(Object x: ints){
            System.out.println();
        }

    }


    @Autowired
    BookService bookService;
    @Test
    public void test04(){
        bookService.checkout("Tom", "ISBN-001");
    }


    @Autowired
    MulService mulService;

    @Test
    public void test05(){
        mulService.mulTx();
    }

}
