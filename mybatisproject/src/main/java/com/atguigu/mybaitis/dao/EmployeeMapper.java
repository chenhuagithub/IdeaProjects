package com.atguigu.mybaitis.dao;

import com.atguigu.mybaitis.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);
    public Employee getEmpByLastname(String lastname);

}
