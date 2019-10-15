package com.atguigu.dao;

import com.atguigu.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapperPlus {

    public Employee getEmpByIdMapResult(Integer id);


    public Map<String, Object> getEmpByIdOneToManyMapResult(Integer id);

    public Employee getEmpByIdOneToManyMapResult2(Integer id);

    public Employee getById(Integer id);

    public Employee getById2(Integer id);

    public List<Employee> getBydid(Integer id);


}
