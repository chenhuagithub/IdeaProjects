package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class demo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        // 获取构造器
        Constructor<Person> constructor = personClass.getConstructor(String.class, Integer.class);
        System.out.println(constructor);
        // 创建对象
        Person person = constructor.newInstance("张三", 45);
        System.out.println(person);

    }


}
