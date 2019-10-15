package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface EmployeeMapperAnnotation {

//    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmpById(Integer id);



}
