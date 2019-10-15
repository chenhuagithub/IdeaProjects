package com.atguigu.algorithm.kmp;

import java.util.Arrays;

/**
 * kmp算法
 * @author chenhua
 */
public class demo {
    public static void main(String[] args) {
        String str1 = "abcabaaaabaabcac";
        String str2 = "abaabcac";
        int[] ints = kmpNext(str2);
        System.out.println(Arrays.toString(ints));
        int i = kmpSearch(str1, str2, ints);
        System.out.println("i="+i);
    }

    /**
     *
     * @param source 源字符串
     * @param target 目标字符串
     * @param next 部分匹配表
     * @return
     */
    public static int kmpSearch(String source, String target, int[] next) {
        for (int i = 0, j= 0; i < source.length(); i++) {
            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = next[j - 1];
            }
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            // 如果j的数值等于目标字符串的长度, 返回下标
            if (j == target.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    /**
     * 获取一个字符串的部分匹配值表
     * @param dest
     * @return
     */
    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int j = 0, i = 1; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            // 当条件满足时, 部分匹配值就加1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
