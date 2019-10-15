package com.atguigu.controller;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.net.www.HeaderParser;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/findOneEmployee")
    public String findEmployee(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id, Model model){
        Employee oneEmployee = employeeService.findOneEmployee(id);
        model.addAttribute("oneEmployee", oneEmployee);
        return "success";
    }

    // 查询员工
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String findAllEmployee(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page, Model model){

        System.out.println("page--->"+page);
        PageHelper.startPage(page, 10);
        List<Employee> allEmployee = employeeService.findAllEmployee();

        PageInfo<Employee> info = new PageInfo<>(allEmployee);

        System.out.println("当前页码:"+info.getPageNum());
        System.out.println("总页码:"+info.getPages());
        System.out.println("总记录数:"+info.getTotal());
        System.out.println("当前页有几条记录"+info.getSize());
        System.out.println("当前页的pageSize:"+info.getPageSize());
        System.out.println("前一页:"+info.getPrePage());
        System.out.println("结果:"+info.getList());

        model.addAttribute("info", info);
        return "success";
    }


    // 添加员工
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        System.out.println("Employee--->"+employee);
        employeeService.addEmployee(employee);
        return "success";
    }


    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        employeeService.deleteEmployee(id);
        return "success";
    }


    @RequestMapping("/gotoedit")
    public String gotoedit(@RequestParam("id")Integer id, Model model){
        Employee oneEmployee = employeeService.findOneEmployee(id);
        System.out.println(oneEmployee);
        model.addAttribute("emp", oneEmployee);
        return "edit";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeService.updateEmployee(employee);
        return "success";
    }






    @Autowired
    DepartmentMapper departmentMapper;

    @RequestMapping("/test")
    public String test(){
//        Department department = departmentMapper.selectById(1);
//        System.out.println(department);
//        System.out.println(department.getId());
//        System.out.println(department.getDepartmentName());
        Department department = departmentMapper.selectId("c++开发部");
        System.out.println(department);
        return "success";
    }

}
