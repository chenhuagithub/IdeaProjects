package com.atguigu.mybatispluscodegenarator;


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

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusCodegenaratorApplicationTests {


//    @Autowired
//    EmployeeMapper employeeMapper;
//
//
//
//    @Test
//    public void test1(){
//        System.out.println("=================");
//        System.out.println(employeeMapper);
//        System.out.println("================");
//
//    }


    @Test
    public void contextLoads() {
        /*
        全局配置
         */
        GlobalConfig config = new GlobalConfig();
        // 是否支持AR模式
        config.setActiveRecord(false)
        // 作者
        .setAuthor("chenhua")
        // 生成路径
        .setOutputDir("/home/chenhua/IdeaProjects/mybatisplus-codegenarator/src/main/java")
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
        packageConfig.setParent("com.atguigu.mybatispluscodegenarator")
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
