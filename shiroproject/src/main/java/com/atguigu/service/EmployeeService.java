package com.atguigu.service;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    public Employee findOneEmployee(Integer id){
        return employeeMapper.findOneEmployee(id);
    }


    public List<Employee> findAllEmployee(){
        return employeeMapper.findAllEmployee();
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void addEmployee(Employee employee){
        employeeMapper.addEmployee(employee);
        Department department = departmentMapper.selectId(employee.getDepartment().getDepartmentName());
        System.out.println("id---->"+employee.getId());
        System.out.println("did--->"+department.getId());
        employeeMapper.addDid(employee.getId(),department.getId());
    }



    public void deleteEmployee(Integer id){
        employeeMapper.deleteEmployee(id);
    }

    //事务管理
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEmployee(Employee employee){
        employeeMapper.updateEmployee(employee);
        Department department = departmentMapper.selectId((employee.getDepartment().getDepartmentName()));
        employeeMapper.addDid(employee.getId(),department.getId());
    }

}
