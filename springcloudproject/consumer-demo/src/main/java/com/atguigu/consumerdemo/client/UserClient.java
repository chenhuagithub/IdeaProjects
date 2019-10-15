package com.atguigu.consumerdemo.client;

import com.atguigu.consumerdemo.bean.Teacher;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("user-service")
public interface UserClient {


    @GetMapping("/teacher/findById/{id}")
    Teacher queryTeacher(@PathVariable("id") Integer id);

}
