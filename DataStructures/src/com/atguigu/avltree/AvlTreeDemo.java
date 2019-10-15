package com.atguigu.avltree;

/**
 * @author chenhua
 *
 */

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AvlTree avlTree = new AvlTree();
        for (int x : arr) {
            avlTree.add(new Node(x));
        }
        System.out.println(avlTree.root.leftHeight());
        System.out.println(avlTree.root.rightHeight());


    }
}


class AvlTree{
    public Node root;

    /**
     * 添加节点
     * @param node 节点
     */
    public void add(Node node){
        if (this.root != null) {
            this.root.add(node);
        }else {
            this.root = node;
        }
    }

    /**
     * 中序遍历
     */
    public void fixOrder() {
        if (this.root != null) {
            this.root.fixOrder();
        }else {
            System.out.println("二叉树为空树, 不能遍历");
        }
    }




}

class Node{
    public int value;
    public Node left;
    public Node right;

    /**
     * 构造方法
     * @param value
     */
    public Node(int value) {
        this.value = value;
    }


    /**
     * 左子树的高度
     * @return
     */
    public int leftHeight(){
        if (this.left == null) {
            return 0;
        }
        return this.left.height();
    }

    /**
     * 右子树的高度
     * @return
     */
    public int rightHeight(){
        if (this.right == null) {
            return 0;
        }
        return this.right.height();
    }

    /**
     * 当前节点的高度
     * @return
     */
    public int height() {
        return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
    }

    /**
     * 添加节点
     * @param node 需要添加的节点
     */
    public void add(Node node){
        if (node.value < this.value) {
            if (this.left != null) {
                this.left.add(node);
            }else {
                this.left = node;
            }
        }else {
            if (this.right != null) {
                this.right.add(node);
            }else {
                this.right = node;
            }
        }

        // 如果右子树高度 - 左子树高度 > 1, 进行左旋转
        if (this.rightHeight() - this.leftHeight() > 1) {
            if (this.right.leftHeight() > this.right.rightHeight()) {
                this.right.rightRotate();
            }
            this.leftRotate();
        }
        // 如果左子树高度 - 右子树高度 > 1, 进行右旋转
        if (this.leftHeight() - this.rightHeight() > 1) {
            if (this.left.rightHeight() > this.left.leftHeight()) {
                this.left.leftRotate();
            }
            this.rightRotate();
        }
    }

    /**
     * 左旋转
     */
    public void leftRotate() {
        Node node = new Node(this.value);
        node.left = this.left;
        node.right = this.right.left;
        this.value = this.right.value;
        this.right = this.right.right;
        this.left = node;
    }

    /**
     * 右旋转
     */
    public void rightRotate() {
        Node node = new Node(this.value);
        node.right = this.right;
        node.left = this.left.right;
        this.value = this.left.value;
        this.left = this.left.left;
        this.right = node;
    }


    /**
     * 中序遍历
     */
    public void fixOrder(){
        if (this.left != null) {
            this.left.fixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.fixOrder();
        }
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

