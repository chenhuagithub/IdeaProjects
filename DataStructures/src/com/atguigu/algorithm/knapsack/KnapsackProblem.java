package com.atguigu.algorithm.knapsack;

/**
 * 动态规划
 * @author chenhua
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        // 物品重量
        int[] w = {1, 4, 3};
        // 物品的价值
        int[] val = {1500, 3000, 2000};
        // 背包容量
        int m = 4;
        // 物品个数
        int n = val.length;
        // 前i个物品中能够装入容器为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n+1][m+1];

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i-1] > j) {
                    v[i][j] = v[i-1][j];
                }else {
                    if (v[i - 1][j] < val[i - 1]+ v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1]+ v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i - 1][j];
                    }

                }
            }
        }


        for (int i = path.length - 1; i > 0; i--) {
            for (int j = path[0].length -1; j > 0; j--) {
                if (path[i][j] == 1) {
                    System.out.println("i="+i);
                }
            }
        }


        // 展示
        for (int[] row : v) {
            for (int column : row) {
                System.out.print(column + "\t");
            }
            System.out.println();
        }
    }
}
