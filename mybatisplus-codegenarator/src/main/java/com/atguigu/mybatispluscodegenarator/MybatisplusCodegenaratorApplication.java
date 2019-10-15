package com.atguigu.mybatispluscodegenarator;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(value = "com.atguigu.mybatispluscodegenarator.mapper")

public class MybatisplusCodegenaratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusCodegenaratorApplication.class, args);
    }

    /**
     * 分页插件
     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
//        return paginationInterceptor;
//    }

}
