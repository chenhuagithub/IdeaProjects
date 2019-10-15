package com.atguigu.service;

import com.atguigu.bean.Teacher;
import com.atguigu.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    public TeacherService(){
        System.out.println("TeacherService被创建了");
    }

    @Autowired
    TeacherDao teacherDao;

    public Teacher getTeacher(Integer id){

        return teacherDao.getTeacherById(id);
    }

}
