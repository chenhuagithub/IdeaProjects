package com.atguigu.dao;

import com.atguigu.bean.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {

    public Department getById(Integer id);

    public Department getById2(Integer id);

    @Select("select * from tbl_dept where id=#{id}")
    public Department getById3(Integer id);


    public Department getByIdPlus(Integer id);


    public Department getByIdStep(Integer id);
}
