package com.atguigu.fenye.service.impl;

import com.atguigu.fenye.bean.Employee;
import com.atguigu.fenye.mapper.EmployeeMapper;
import com.atguigu.fenye.service.EmployeeService;
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
