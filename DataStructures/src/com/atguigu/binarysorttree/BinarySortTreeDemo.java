package com.atguigu.binarysorttree;

import com.atguigu.digui.MiGong;
import com.sun.org.apache.bcel.internal.generic.BIPUSH;

/**
 * @author chenhua
 */
@SuppressWarnings("ALL")
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int x : arr){
            binarySortTree.addNode(new Node(x));
        }


        binarySortTree.fixOrder();
        System.out.println("===========================");
        Node currentNode = binarySortTree.search(7);
        System.out.println(currentNode);
        binarySortTree.delMinTreeNode(currentNode);
        System.out.println("----------------------");
        binarySortTree.fixOrder();


    }
}


class BinarySortTree{
    private Node root;



    // 寻找要删除的节点
    public Node search(int value){
        if (this.root != null){
            return this.root.search(value);
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    // 添加节点
    public void addNode(Node node){
        if (this.root == null){
            this.root = node;
        }else {
            this.root.addNode(node);
        }
    }

    // 中序遍历
    public void fixOrder(){
        if (this.root != null){
            this.root.fixOrder();
        }else {
            System.out.println("二叉树为空, 不能进行遍历");
        }
    }


    // 寻找删除节点的父节点
    public  Node seachParent(int value){
        if (this.root != null) {
            return this.root.searchParent(value);
        }else {
            return null;
        }
    }


    /**
     * 删除叶子节点
     * @param parentNode
     * @param value
     */
    public void delLeafNode(Node parentNode, int value){

        if (parentNode.left != null && parentNode.left.value == value) {
            parentNode.left = null;
        } else if (parentNode.right != null && parentNode.right.value == value) {
            parentNode.right = null;
        }
    }

    /**
     * 删除带有一个叶子节点的父节点
     * @param parentNode
     * @param currentNode
     */
    public void delHaveOneLeafNode(Node parentNode, Node currentNode){
        // 左节点
        if (parentNode.left.value == currentNode.value){
            if (currentNode.left != null) {
                parentNode.left = currentNode.left;
            }else {
                parentNode.left = currentNode.right;
            }
        }else {
            if (currentNode.left != null) {
                parentNode.right = currentNode.left;
            }else {
                parentNode.right = currentNode.right;
            }
        }
    }

    // 寻找子树中的最小节点
    public Node searchMinTreeNode(Node node){
        if (this.root != null) {
            return this.root.searchMinTreeNode(node);
        }else {
            System.out.println("二叉树为空");
            return null;
        }

    }


    /**
     * 删除node为根节点的二叉排序树的最小节点
     * @param node
     * @return
     */
    public Node getMinTreeMin(Node node){
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        return target;
    }

    public Node getMaxTree(Node node){
        Node target = node;
        while (target.right != null) {
            target = target.right;
        }
        return target;
    }

    /**
     * 删除最小节点
     * @param node
     */
    public void delMinTreeNode(Node node){
        if (node.right.left != null) {
            Node minTreeMin = getMinTreeMin(node.right);
            Node parent = this.root.searchParent(minTreeMin.value);
            delLeafNode(parent, minTreeMin.value);
            node.value = minTreeMin.value;
        }else {
            Node maxTree = getMaxTree(node.left);
//            System.out.println("maxTree="+maxTree);
            Node parent = this.root.searchParent(maxTree.value);
//            System.out.println("parent="+parent);
            delLeafNode(parent, maxTree.value);
            node.value = maxTree.value;
//            System.out.println(maxTree);

        }
    }





    // 删除子树的父节点
    public void delChirldTreeNode(Node parentNode, Node currentNode, Node minNode){
        Node temp = minNode;
        if (this.root != null) {
            currentNode.value = temp.value;
            if (parentNode.left.value == minNode.value){
                parentNode.left = null;
            }
            if (parentNode.right.value == minNode.value) {
                parentNode.right = null;
            }
        }else {
            System.out.println("二叉树为空");
            return;
        }
    }





}


class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(){

    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // 中序遍历
    public void fixOrder(){
        if (this.left != null){
            this.left.fixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.fixOrder();
        }
    }

    // 查找要删除的节点
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value) {
            if (this.left != null) {
                return this.left.search(value);
            }else {
                return null;
            }
        }else {
            if (this.right != null) {
                return this.right.search(value);
            }else {
                return null;
            }
        }

    }

    // 添加节点
    public void addNode(Node node){
        // 左递归插入数据
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            }else {
                this.left.addNode(node);
            }
        }else { // 右递归插入数据
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.addNode(node);
            }
        }
    }


    // 寻找删除节点的父节点
    public Node searchParent(int value){
        // 左递归查找
        if (this.left !=null && this.left.value == value) {
            return this;
        }else if (this.right != null && this.right.value == value) {
            return this;
        } else if (value < this.value) {
            return this.left.searchParent(value);
        } else if (value > this.value) {
            return this.right.searchParent(value);
        }else {
            return null;
        }

    }


    /**
     * 寻找子树中最小节点
     * @param node 当前节点
     * @return 最小节点
     */
    public Node searchMinTreeNode(Node node){
        if (node.right.left != null) {
            searchMinTreeNode(node.right.left);
        }
        if (node.right.left.left == null){
            return node.right.left.left;
        }

        return node.left;
    }




}


