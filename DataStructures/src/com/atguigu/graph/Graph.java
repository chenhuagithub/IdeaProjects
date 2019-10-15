package com.atguigu.graph;

import java.util.ArrayList;

/**
 * @author chenhua
 */

public class Graph {

    /**
     * 存储图的对应邻接矩阵
     */
    private int[][] edges;
    /**
     * 存储顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 表示边的数目
     */
    private int numOfEdges;

    /**
     * 是否被访问过
     */
    public boolean[] isVisit;


    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>();
        numOfEdges = 0;

    }

    /**
     * 添加节点
     * @param vertex
     */
    public void insertVertex(String vertex) {
        this.vertexList.add(vertex);
    }

    /**
     * 添加边
     * @param v1 数组下标
     * @param v2 数组下标
     * @param weight 边的权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        this.edges[v1][v2] = weight;
        this.edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 返回节点的个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 返回边的条数
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回节点i对应的数据
     * @param i 数组索引
     * @return
     */
    public String getValueByIndex(int i) {
        return this.vertexList.get(i);
    }

    /**
     * 返回权值
     * @param v1 数组下标
     * @param v2 数组下标
     * @return
     */
    public int getWeight(int v1, int v2) {
        return this.edges[v1][v2];
    }

    /**
     * 显示矩阵
     */
    public void showGraph() {
        for (int[] row : this.edges) {
            for (int column : row) {
                System.out.print(column + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 得到第一个邻接节点的下标
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < this.vertexList.size(); i++) {
            if (this.edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接节点的下标来获取下一个邻接节点
     * @param row 行
     * @return
     */
    public int getNextNeighbor(int row, int column) {
        for (int i = column + 1; i < this.vertexList.size(); i++) {
            if (this.edges[row][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * @param i
     */
    public void dfs(int i) {
        this.isVisit[i] = true;
        System.out.println(this.vertexList.get(i));
        // 第一个节点
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!this.isVisit[w]) {
                dfs(w);
            }
            w = getNextNeighbor(i, w);


        }


    }

    /**
     * 对一个节点进行广度优先遍历
     * @param i 当前节点的下标
     */
     public void bfs(int i) {
         // 用一个队列保存一个临接节点
         ArrayList<Integer> queue = new ArrayList<>();
         this.isVisit[i] = true;
         queue.add(i);
         System.out.println(this.vertexList.get(i));

         while (!queue.isEmpty()) {
             // 取出队列头结点
             Integer u = queue.remove(0);
             // 下一个节点
             Integer w = getFirstNeighbor(u);
             while (w != -1) {
                 if (!this.isVisit[w]) {
                     System.out.println(this.vertexList.get(w));
                     this.isVisit[w] = true;
                     queue.add(w);
                 }
                 w = getNextNeighbor(u, w);
             }

         }



     }

    /**
     * 对每个节点进行循环遍历, 避免有独立的节点
     */
    public void dfs(){
        isVisit = new boolean[this.getNumOfVertex()];
        System.out.println("深度遍历");
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisit[i]) {
                dfs(i);
            }
        }
    }

    /**
     *
     */
    public void bfs() {
        isVisit = new boolean[this.getNumOfVertex()];
        System.out.println("广度优先遍历");
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisit[i]) {
                bfs(i);
            }
        }
    }




}
