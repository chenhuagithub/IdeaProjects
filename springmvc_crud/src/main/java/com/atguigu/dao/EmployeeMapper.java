package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    // 新增员工信息
    public void addEmployee(Employee employee);

    // 查询一个员工
    public Employee findOneEmployee(Integer id);

    // 查询所有员工
    public List<Employee> findAllEmployee();

    // 更新员工信息
    public void updateEmployee(Employee employee);

    // 删除员工
    public void deleteEmployee(Integer id);

    //添加外键
    public void addDid(@Param("id") Integer id, @Param("did") Integer did);

}
