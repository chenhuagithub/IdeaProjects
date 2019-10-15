package com.atguigu.algorithm.binarysearchnorecursion.minTree;

/**
 * @author chenhua
 */
public class MGraph {
    /**
     * 图的节点数
     */
    int verxs;
    /**
     * 存放节点数据
     */
    char[] data;
    /**
     * 存放边, 就是我们的邻接矩阵
     */
    int[][] weight;

    public MGraph() {

    }

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }



}
