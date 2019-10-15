package com.atguigu.springbootmybatisdemo.mapper;

import com.atguigu.springbootmybatisdemo.bean.Person;

public interface PersonMapper {

    public Person findById(Integer id);

}
