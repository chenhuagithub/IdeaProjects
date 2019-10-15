package com.atguigu.dao;

import com.atguigu.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper{

    //返回多个map
    @MapKey("lastName")
    public Map<String, Employee> selectByIdReturnMoreMap(String lastName);
    //返回Map类型
    public Map<String, Object> selectByIdReturnMap(Integer id);
    //通过map查询
    public Employee EmpByMap(Map<String , Object> map);
    // 通过id查询数据库
    public Employee EmpById(@Param("id")Integer id, @Param("lastName")String lastName);
    // 增
    public void addEmp(Employee employee);
    //删
    public void deleteEmpById(Integer id);
    // 改
    public void updateEmp(Employee employee);

    //返回类型是List
    public List<Employee> selectByLastName(String lastName);

    public Employee getByIdDis(Integer id);





}
