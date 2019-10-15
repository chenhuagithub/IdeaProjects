package com.atguigu.sort;

import java.util.Arrays;

/**
 * 堆铺排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 9, 20, 8, 7, 5, 22, 6};
        heapSort(arr);
    }


    public static void heapSort(int arr[]){
        System.out.println("堆排序");
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次:"+ Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次:"+Arrays.toString(arr));
        int temp = 0;
        for (int i = arr.length / 2 -1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }


        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println("数组="+Arrays.toString(arr));
    }


    /**
     * @param arr 数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整, length是在逐渐减少
     */
    public static void adjustHeap(int arr[], int i, int length){
        // 标记父节点
        int temp = arr[i];

        for (int j = 2 * i +1; j < length; j = 2 * j +1 ) {
            if (j+1 < length && arr[j] < arr[j+1]){
                j++;
            }
            if (arr[j] > temp){
                arr[i] = arr[j];
                i = j;
            }else {
                break;
            }
            arr[i] = temp;
        }
    }


}
