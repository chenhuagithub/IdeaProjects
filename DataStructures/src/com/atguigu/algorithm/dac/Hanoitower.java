package com.atguigu.algorithm.dac;

/**
 * 分治算法
 * @author chenhua
 */
public class Hanoitower {
    public static void main(String[] args) {
        remove(64, 'a', 'b', 'c');
    }

    public static void remove(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + "->" + c);
            return;
        }
        remove(num - 1, a, c, b);
        System.out.println(a + "->" + c);
        remove(num - 1, b, a, c);

    }
}
