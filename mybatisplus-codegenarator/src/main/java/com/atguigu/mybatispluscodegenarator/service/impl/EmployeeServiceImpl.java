package com.atguigu.mybatispluscodegenarator.service.impl;

import com.atguigu.mybatispluscodegenarator.bean.Employee;
import com.atguigu.mybatispluscodegenarator.mapper.EmployeeMapper;
import com.atguigu.mybatispluscodegenarator.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhua
 * @since 2019-08-27
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
