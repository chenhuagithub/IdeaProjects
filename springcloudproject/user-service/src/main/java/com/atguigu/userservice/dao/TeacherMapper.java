package com.atguigu.userservice.dao;

import com.atguigu.userservice.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    public Teacher findById(Integer id);


}
