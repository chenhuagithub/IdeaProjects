package com.atguigu;

import com.atguigu.bean.Teacher;
import com.atguigu.dao.TeacherMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class test_mbg {

    @Test
    public void test() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<String>();
        System.out.println("aaaa");
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        System.out.println("bbb");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        System.out.println("cccc");
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("dddd");
    }


    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void test02(){
        List<Teacher> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Teacher teacher = new Teacher();
            teacher.setName(UUID.randomUUID().toString().substring(0,5));
            teacher.setCourse(UUID.randomUUID().toString().substring(0,5));
            list.add(teacher);
        }
        System.out.println("批量保存....");
        teacherMapper.insertBatch(list);
    }

    @Test
    public void pageTest(){
        
    }

}
