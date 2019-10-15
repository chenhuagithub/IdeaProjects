package com.atguigu.queue;

import java.util.Scanner;

public class CicleQueueDemo {

    public static void main(String[] args) {
        CicleQueue arrayQueue = new CicleQueue(4);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';

        while (true){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("a(add): 添加队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':arrayQueue.showQueue();break;

                case 'e':break;

                case 'a':
                    System.out.print("请输入数据:");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;

                case 'g':
                    int queue = arrayQueue.getQueue();
                    System.out.println(queue);
                    break;

                case 'h':
                    int headQueue = arrayQueue.headQueue();
                    System.out.println(headQueue);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + key);
            }
        }
    }


}


class CicleQueue{
    // 队列最大容量
    private int maxSize;
    // 队列头, 初始值为0
    private int front;
    // 队列尾, 初始值为0
    private int rear;
    // 队列数组
    private int[] arr;

    public CicleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    // 判断队列是否已满
    public boolean isFull(){
        return (this.rear+1)%this.maxSize==this.front;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return this.rear == this.front;
    }

    // 添加元素到队列
    public void addQueue(int param){
        // 判断队列是否已满
        if(this.isFull()){
            throw new RuntimeException("队列已满");
        }
        this.arr[this.rear] = param;
        this.rear = (rear+1)%this.maxSize;
    }


    // 取出队列的元素, 出队
    public int getQueue(){
        // 判断队列是否为空
        if(this.isEmpty()){
            throw new RuntimeException("队列不能为空");
        }
        // 用一个变量保存取出的值
        int value = this.arr[this.front];
        // 头部后移
        this.front = (this.front+1)%this.maxSize;
        // 返回取出的值
        System.out.println("front---->"+this.front);
        return value;
    }

    // 显示所有队列的元素
    public void showQueue(){
        for (int i = this.front; i < this.front + this.size(); i++) {
            System.out.print(this.arr[i%this.maxSize]+"\t");
        }
    }



    // 队列中有效元素的个数
    public int size(){
        return (this.rear+this.maxSize-this.front)%this.maxSize;
    }


    // 显示队列的头元素
    public int headQueue(){
        return this.arr[this.front];
    }


}