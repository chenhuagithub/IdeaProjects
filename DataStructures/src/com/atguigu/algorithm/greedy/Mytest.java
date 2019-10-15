package com.atguigu.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mytest {
    public static void main(String[] args) {
        Set<String> list1 = new HashSet<>();
        Set<String> list2 = new HashSet<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list2.add("1");
        list2.add("2");
        list2.add("5");
        list1.retainAll(list2);
        System.out.println(list1);

    }
}
