package com.atguigu.algorithm.binarysearchnorecursion.minTree;

/**
 * 普里姆算法
 * @author chenhua
 */
public class MinTree {

    /**
     * 创建图片
     * @param graph
     * @param verxs
     * @param data
     * @param weight
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        for (int i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 遍历图
     * @param graph
     */
    public void showGraph(MGraph graph) {
        for (int[] row : graph.weight) {
            for (int column : row) {
                System.out.print(column+ "\t");
            }
            System.out.println();
        }
    }

    /**
     * 生成最小生成树
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成最小生成树
     */
    public void prim(MGraph graph, int v) {
        // 标记节点是否被访问过
        int[] visited = new int[graph.verxs];

        visited[v] = 1;

        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;

        for (int k = 0; k < graph.verxs; k++) {
            for (int i = 0; i < graph.verxs; i++) {
                for (int j = 0; j < graph.verxs; j++) {
                    if (minWeight > graph.weight[i][j] && visited[i] == 1 && visited[j] == 0) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }

            }
            System.out.println("边<"+graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            visited[h2] = 1;
            minWeight = 10000;

        }
    }

}
