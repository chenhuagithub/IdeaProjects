package com.atguigu.userservice.service;

import com.atguigu.userservice.bean.Teacher;
import com.atguigu.userservice.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;


    public Teacher findById(Integer id){
        return teacherMapper.findById(id);
    }

}
