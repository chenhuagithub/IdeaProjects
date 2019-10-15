package com.atguigu.service;

import com.atguigu.bean.Person;
import com.atguigu.dao.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonMapper personMapper;

    public void addPerson(Person person){
        personMapper.addPerson(person);
    }


    public List<Person> findAllPerson(){
        return personMapper.findAllPerson();
    }

}
