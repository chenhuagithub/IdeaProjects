package com.atguigu.tree;

import java.sql.SQLOutput;

/**
 * 二叉树的创建, 遍历和删除
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊逸");
        HeroNode node4 = new HeroNode(4, "林冲");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);

        // 前序遍历
        System.out.println("前序遍历");
        binaryTree.setRoot(root);
        binaryTree.preOrder();

        // 中序遍历
        System.out.println("中序遍历");
        binaryTree.infixOrder();

        // 后序遍历
        System.out.println("后序遍历");
        binaryTree.postOrder();

        // 前序查找
        System.out.println("前序查找");
        HeroNode heroNode = binaryTree.preOrderSearch(3);
        System.out.println(heroNode);

        // 中序查找
        System.out.println("中序查找");
        HeroNode heroNode1 = binaryTree.infixOrderSearch(3);
        System.out.println(heroNode1);

        // 删除节点
        System.out.println("删除树");
        binaryTree.delNode(3);
        binaryTree.preOrder();


    }


}

// 二叉树
class BinaryTree{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder(){
        if (this.root != null) {
            this.root.preOrder();
        }else {
            System.out.println("二叉树玩为空, 无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空, 无法遍历");
        }
    }

    // 后序遍历
    public void postOrder(){
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空, 无法遍历");
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int n){
        if (this.root != null) {
            return this.root.preOrderSearch(n);
        }else {
            return null;
        }
    }

    // 中序查找
    public HeroNode infixOrderSearch(int n){
        if (this.root != null) {
            return this.root.infixOrderSearch(n);
        }else {
            return null;
        }
    }

    // 删除节点
    public void delNode(int no){
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
            }else {
                this.root.delNode(no);
            }
        }else {
            System.out.println("空树, 不能删除");
        }
    }


}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;


    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 编写前序遍历算法
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
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

    // 后序遍历
    public void postOrder(){
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找
    public HeroNode preOrderSearch(int no){

        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode =  this.left.preOrderSearch(no);
        }
        if (this.right != null) {
            resNode =  this.right.preOrderSearch(no);
        }
        return resNode;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int no){
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }


    // 前序遍历删除节点
    public void delNode(int no){
        // 只有一个节点的情况
        if (this.no == no) {
            System.out.println("只有一个节点");
        }
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }



    }


}


