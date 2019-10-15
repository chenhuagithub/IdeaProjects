package com.atguigu.dao;

import com.atguigu.bean.Department;

import java.util.List;

public interface DepartmentMapper {


    // 新增部门
    public void addDepartment(Department department);

    // 查询所有部门
    public List<Department> findAllDepartment();

    // 查询一个部门
    public Department findOneDepartment(Integer id);

    // 删除部门
    public void deleteDepartment(Integer id);

    // 修改部门
    public void updateDepartment(Integer id);


    // 查询id
    public Department selectId(String departmentName);


    public Department selectById(Integer id);



}
