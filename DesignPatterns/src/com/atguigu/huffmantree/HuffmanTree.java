package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        // 前序遍历
        perOreder(root);
    }

    // 前序遍历
    public static void perOreder(Node root){
        System.out.println("前序遍历");
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("树为空, 不能遍历");
        }
    }

    public static Node createHuffmanTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr){
            nodes.add(new Node(value));
        }

        for (int i = 0; i < arr.length - 1; i++) {
            // 排序
            Collections.sort(nodes);

            // 获取最小的节点
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parentNode = new Node(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 添加父节点
            nodes.add(parentNode);
            System.out.println("nodes="+nodes);
        }

        return nodes.get(0);

    }

}




class Node implements Comparable<Node> {

    public  int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    // 前序遍历
    public void preOrder(){
        if (this == null){
            return;
        }
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }

    }
}