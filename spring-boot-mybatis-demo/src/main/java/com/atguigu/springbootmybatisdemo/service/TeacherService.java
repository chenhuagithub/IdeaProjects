package com.atguigu.springbootmybatisdemo.service;

import com.atguigu.springbootmybatisdemo.mapper.TeacherMapper;
import com.atguigu.springbootmybatisdemo.bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {


    @Autowired
    TeacherMapper teacherMapper;

    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    public int deleteTeacher(Integer id) {
        return teacherMapper.deleteTeacher(id);
    }
}
