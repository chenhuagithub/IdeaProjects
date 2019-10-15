package com.atguigu.service;

import com.atguigu.bean.Teacher;
import com.atguigu.dao.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> getall(){
        List<Teacher> list = teacherMapper.getall();
        return list;
    }

}
