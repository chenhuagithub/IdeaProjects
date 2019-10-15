package com.atguigu.digui;


public class Queue8 {

    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    static int num = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有"+count+"种解法");
        System.out.println("判断次数:"+num);
    }


    public void check(int n){
        if(n == max){
//            int k = 1/0;
            print();
            return;
        }

        // 依次放入皇后, 并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把但前这个皇后n, 放到该行的第一列
            array[n] = i;
            // 判断当放置第n个皇后到第i列时, 是否冲突
            if(judge(n)){
                check(n+1);
            }
        }
    }

    public void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }

    // 判断是否符合条件
    public boolean judge(int n){
        num++;
        for (int i = 0; i < n; i++) {
            // 说明
            // 1. array[i] == array[n]判断是否在同一列
            // 2. Math.abs(array[n] - array[i])判断是否在同一斜线
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }


}
