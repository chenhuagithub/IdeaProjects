package com.atguigu.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int x : arr){
            binarySortTree.add(new Node(x));
        }
        binarySortTree.infixOrder();
    }

}

class BinarySortTree{
    private Node root;

    public void add(Node node){
        if (root == null) {
            this.root = node;
        }else {
            this.root.addNode(node);
        }
    }


    public void infixOrder(){
        if (this.root != null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空, 无法遍历");
        }
    }
}

class Node{
    public int value;
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


    public void addNode(Node node){
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            }else {
                this.left.addNode(node);
            }
        }else {
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.addNode(node);
            }
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

}