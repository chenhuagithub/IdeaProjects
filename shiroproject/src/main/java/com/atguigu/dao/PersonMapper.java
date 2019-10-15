package com.atguigu.dao;

import com.atguigu.bean.Person;

import java.util.List;

public interface PersonMapper {

    public void addPerson(Person person);

    public List<Person> findAllPerson();

}
