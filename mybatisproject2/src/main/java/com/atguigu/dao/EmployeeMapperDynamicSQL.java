package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Arrays;
import java.util.List;

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getByConditionIf(Employee employee);

    public List<Employee> getByConditionIf2(Employee employee);

    public List<Employee> getByChoose(Employee employee);

    public void updateEmp(Employee employee);

    public List<Employee> getByIdForeach(List<Integer> ids);

    public void addEmpsForeach(@Param("emps") List<Employee> emps);

    public List<Employee> findBylastName(String lastName);

}
