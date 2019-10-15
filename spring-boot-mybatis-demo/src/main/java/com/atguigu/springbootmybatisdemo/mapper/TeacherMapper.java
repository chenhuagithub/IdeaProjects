package com.atguigu.springbootmybatisdemo.mapper;

import com.atguigu.springbootmybatisdemo.bean.Teacher;

//@mapper  // 该注解标识该接口是mybatis实现接口
public interface TeacherMapper {

//    @Select("select * from teacher where id = #{id}")
    public Teacher getTeacherById(Integer id);

//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @Insert("insert into teacher(teacher_name, age, hobby)values(#{teacherName}, #{age}, #{hobby})")
    public int insertTeacher(Teacher teacher);

//    @Update("update teacher set name=#{name}, age=#{age}, hobby=#{hobby} where id = #{id}")
    public int updateTeacher(Teacher teacher);

//    @Delete("delete from teacher where id = #{id}")
    public int deleteTeacher(Integer id);

}
