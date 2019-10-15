package com.atguigu.graph;

import com.sun.org.apache.xpath.internal.operations.Gt;

import java.util.ArrayList;

/**
 * @author chenhua
 */
public class GraphDemo {
    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String str : vertexValue) {
            graph.insertVertex(str);
        }

        graph.insertEdge(0, 2, 1);
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(2, 1, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 0 ,1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(3, 1, 1);
        System.out.println("邻接矩阵");
        graph.showGraph();

        System.out.println("节点个数");
        int numOfVertex = graph.getNumOfVertex();
        System.out.println(numOfVertex);
        System.out.println("边的条数");
        int numOfEdges = graph.getNumOfEdges();
        System.out.println(numOfEdges);

        graph.dfs();
        graph.bfs();


    }
}


