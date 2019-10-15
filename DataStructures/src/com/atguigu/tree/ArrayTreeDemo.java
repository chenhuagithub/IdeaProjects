package com.atguigu.tree;

public class ArrayTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        preOrder(arr, 0);


    }


    // 前序遍历
    public static void preOrder(int[] arr, int index){
        if (arr.length == 0){
            System.out.println("数组为空, 无法进行前序遍历");
            return;
        }
        System.out.println(arr[index]);
        if(2 * index +1 >= arr.length){
            return;
        }else {
            preOrder(arr, 2 * index +1);
        }
        if(2 * index +2 >= arr.length){
            return;
        }else {
            preOrder(arr, 2 * index +2);
        }


    }


}


