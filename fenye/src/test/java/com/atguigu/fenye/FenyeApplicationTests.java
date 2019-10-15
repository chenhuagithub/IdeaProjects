package com.atguigu.fenye;

import com.atguigu.fenye.bean.Employee;
import com.atguigu.fenye.mapper.EmployeeMapper;
import com.atguigu.fenye.service.EmployeeService;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FenyeApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeService employeeService;


    @Test
    public void test4(){
        System.out.println(employeeService);
    }


    @Test
    public void test3(){
        List<Employee> employees = employeeMapper.selectList(null);
        System.out.println(employees);
    }

    @Test
    public void test2(){
        employeeMapper.deleteAll();
    }

    @Test
    public void test1(){

        IPage<Employee> age = employeeService.page(new Page<>(1, 2), null);
        System.out.println(age.getPages());
        System.out.println(age.getRecords());
    }


    @Test
    public void contextLoads() {
        /**
            全局配置
         */
        GlobalConfig config = new GlobalConfig();
        // 是否支持AR模式
        config.setActiveRecord(false)
                // 作者
                .setAuthor("chenhua")
                // 生成路径
                .setOutputDir("/home/chenhua/IdeaProjects/fenye/src/main/java")
                // 文件覆盖
                .setFileOverride(true)
                // 主键策略
                .setIdType(IdType.AUTO)
                // 设置肾功能成的service接口的名字的手字母是否为I
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        /**
         * 数据源配置
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        // 设置数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mp")
                .setUsername("root")
                .setPassword("123456");


        /**
         * 策略配置
         *
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        // 全局大写命名
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("tbl_")
                // 生成的表
                .setInclude("tbl_employee");

        /**
         * 包名策略配置
         */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.atguigu.fenye")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("bean");
//                .setXml("mapper");

        /**
         * 整合配置
         */
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);


        /**
         * 执行
         */
        autoGenerator.execute();
    }

}
