package com.atguigu.algorithm.binarysearchnorecursion.minTree;

/**
 * @author chenhua
 */
public class MyTest {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        MinTree minTree = new MinTree();
        MGraph mGraph = new MGraph(verxs);
        minTree.createGraph(mGraph, verxs, data, weight);
        minTree.showGraph(mGraph);
        minTree.prim(mGraph, 0);
    }
}
