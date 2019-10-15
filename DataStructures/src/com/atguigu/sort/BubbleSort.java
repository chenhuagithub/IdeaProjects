package com.atguigu.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

    public static void main(String[] args) {
//        int[] array= new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            array[i] = (int)(Math.random()*8000000);
//        }
//        System.out.println("原始数组"+Arrays.toString(array));


        int[] array = {53, 3, 542, 748, 14, 214};
        radixSort(array);


//        int[] temp = new int[array.length];
//        System.out.println(Arrays.toString(array));
//        mergetSort(array, 0, array.length - 1, temp);
//        System.out.println(Arrays.toString(array));

//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dataStr = simpleDateFormat.format(date);
//        System.out.println(dataStr);
//        quickSort(array,0, array.length-1);
//        Date date2 = new Date();
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dataStr2 = simpleDateFormat2.format(date2);
//        System.out.println(dataStr2);
//        System.out.println(Arrays.toString(array));


    }


    // 基数排序
    public static void radixSort(int[] array){

        // 获取数组中最大的值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
        }

        // 获取最大数的位数
        int maxNum = 1;
        while (max / 10 > 0){
            max /=10;
            maxNum++;
        }
        System.out.println("maxNum="+maxNum);


        // 定义一个二维数组, 用来表示10个桶
        int[][] bucket = new int[10][array.length];
        // 定义一个数组来记录每个桶中有多少个数据, 以便从桶中取出数据
        int[] bucketElementCounts = new int[10];
        int index = 0;

        // 数组中最大的数有多少位数, for循环就遍历多少次
        for (int k = 0; k < maxNum; k++) {

            // 循环遍历array数组取出尾数, 把该数放入相应的桶中
            for (int i = 0; i < array.length; i++) {
                int digitOfElement = array[i] / (int)Math.pow(10, k)  % 10;
                // 把数据放入相应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[i];
                // 桶中的数据个数加一
                bucketElementCounts[digitOfElement]++;
            }

            index = 0;
            // 把桶中的数据取出来放回原来的数组中
            for (int i = 0; i < bucketElementCounts.length; i++) {
                if(bucketElementCounts[i] > 0){
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        array[index] = bucket[i][j];
                        index++;
                    }
                }
                // 把桶中的元素个数标记为0
                bucketElementCounts[i] = 0;
            }

            System.out.println(Arrays.toString(array));
        }




    }


    // 归并排序
    public static void mergetSort(int[] array, int left, int right, int[] temp){

        if(left < right){
            int mid = (left + right) / 2;
            // 向左递归进行分解
            mergetSort(array, left, mid, temp);
            // 向右递归进行分解
            mergetSort(array, mid+1, right, temp);
            // 合并
            merge(array, left, mid, right, temp);
        }

    }

    // 合并的方法

    /**
     *
     * @param array 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp){
        // 初始化i, 左边有序序列的初始索引
        int i = left;
        // 初始化j,右边有序序列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        // 先把左右两边(有序)的数据按照规则填充到temp数组, 直到左右两边的有序序列有一边处理完毕为止
        while (i <= mid && j <= right){
            // 如果左边的有序序列的当前元素小于或者等于右边有序序列的当前元素, 则把左边的当前元素拷贝到temp数组
            if(array[i] < array[j]){
                temp[t] = array[i];
                t++;
                i++;
            }else {
                // 反之, 把右边的当前元素拷贝到temp数组
                temp[t] = array[j];
                t++;
                j++;
            }
        }

        // 把有剩余数据的一边的数据依次全部填充到temp
        while (i <= mid){
            temp[t] = array[i];
            t++;
            i++;
        }

        while (j <= array.length - 1){
            temp[t] = array[j];
            t++;
            j++;
        }

        // 将temp数组的元素拷贝到array
        // 注意, 并不是每次都是拷贝所有
        t = 0;
        int tempLeft = left;

        while (tempLeft <= right){
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }


    }


    //  冒泡排序
    public static void bubbleSort(int[] array){

        boolean flag = false;
        int item;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j+1]){
                    flag = true;
                    item = array[j];
                    array[j] = array[j+1];
                    array[j+1] = item;
                }
            }
            System.out.println("第"+(i+1)+"趟"+ Arrays.toString(array) +"");

            if(flag){
                flag = false;
            }else {
                break;
            }

        }
    }


    // 选择排序
    public static void selectSort(int[] array){


        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            int min = array[i];
            // 假定第一个元素为最小值array[i]
            for (int j = i+1; j < array.length; j++) {
                if(min > array[j]){
                    min = array[i];
                    minIndex = j;
                }

            }
            if(minIndex !=i){
                array[minIndex] = array[i];
                array[i] = min;
            }
//            System.out.println("第"+(i+1)+"轮"+Arrays.toString(array));
        }

//        System.out.println(Arrays.toString(array));
    }


    // 插入排序
    public static void insertSort(int[] array){
        // 102 334 119 1
        // 中间转换变量
        int temp;
        int index;

//        // 第一轮
//        temp = array[1];
//        index = 1 - 1;
//
//        while (index > 0 && temp < array[index]){
//            array[index+1] = array[index];
//            index--;
//        }
//        array[index] = temp;
//        System.out.println(Arrays.toString(array));
//        //  第二轮
//        temp = array[2];
//        index = 2 - 1;
//        while (index > 0 && temp < array[index]){
//            array[index + 1] = array[index];
//            index--;
//        }
//
//        array[index + 1] = temp;
//        System.out.println(Arrays.toString(array));


        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            index = i - 1;
            while (index >= 0 && temp < array[index]){
                array[index + 1] = array[index];
                index--;
            }
            array[index+1] = temp;
//            System.out.println("第"+i+"轮"+Arrays.toString(array));
        }

    }


    // 希尔排序(是插入排序的一种)
    public static void shellSort(int[] array){
        int temp;
        int groud = array.length/2;
        // 交换法
        while (groud >= 1){

            for (int i = groud; i < array.length; i++) {

                for (int j = i-groud; j >= 0 ; j-=groud) {
                    if (array[j] > array[j+groud]){
                        temp = array[j];
                        array[j] = array[j+groud];
                        array[j+groud] = temp;
                    }
                }
            }

            groud = groud/2;
        }



        System.out.println(Arrays.toString(array));

    }


    // 快速排序
    public static void quickSort(int[] array, int left, int right){
        // 左下标
        int l = left;
        // 右下标
        int r = right;
        // 中轴值
        int pivot = array[(left + right) / 2];
        // 中间转化变量
        int temp;

        // while循环, 用于交换左右元素
        while (r > l){
            // 在左找出比中轴值大的元素
            while (array[l] < pivot){
                l++;
            }

            // 在右边找出碧中轴值小的元素
            while (array[r] > pivot){
                r--;
            }

            // 左右下标如果没有超过中间轴的下标, 交换左右元素
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            // 如果左右下标超过中间轴的下标值, 退出while循环
            if(l >= r){
                break;
            }

            if(array[l] == pivot){
                l++;
            }

            if(array[r] == pivot){
                r--;
            }

        }

        // 如果l==r, 必须l++,r--, 否则会出现栈溢出
        if(l==r){
            l++;
            r--;
        }

        // 向左递归
        if(left < r){
            quickSort(array, left, r);
        }

        // 向右递归
        if(right > l){
            quickSort(array, l, right);
        }

    }




}
