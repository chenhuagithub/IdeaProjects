package com.atguigu.algorithm.binarysearchnorecursion;

/**
 * @author chenhua
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int i = binarySearch(arr, 7);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (right >= left) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                right = mid -1;
            }
            if (target > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
