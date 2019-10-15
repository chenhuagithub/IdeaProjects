package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetMethodDemo {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<Person> personClass = Person.class;
        // 实例化对象
        Constructor<Person> constructor = personClass.getConstructor();
        Person person = constructor.newInstance();
        Method getName = personClass.getMethod("getName");
        System.out.println(getName);
        // 执行方法
        Object invoke = getName.invoke(person);
        System.out.println();


        // 执行有参函数
        Method eat = personClass.getMethod("eat", String.class);
        System.out.println(eat);
        Object fish = eat.invoke(person, "鱼");


    }

}
