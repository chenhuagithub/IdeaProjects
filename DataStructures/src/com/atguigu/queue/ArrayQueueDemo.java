package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

// 使用数组模拟队列编写一个类
class ArrayQueue{
    // 队列最大容量
    private int maxSize;
    // 队列头
    private int front;
    // 队列尾
    private int rear;
    // 队列数组
    private int[] arr;


    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    // 判断队列是否满
    public boolean isFull(){
        return this.rear == this.maxSize-1;
    }

    // 判断队列是否为空
    public boolean isEmpty(){
        return this.rear == this.front;
    }


    // 添加数据到队列
    public void addQueue(int param){
        // 判断队列是否已满
        if(this.isFull()){
            System.out.println("队列已经满了~~");
            return;
        }
        rear++;
        this.arr[rear] = param;
    }


    // 获取队列的数据, 出队
    public int getQueue(){
        // 判断队列是否为空
        if(this.isEmpty()){
            throw new RuntimeException("队列为空, 不能取出数据");
        }
        this.front++;
        return arr[front];
    }

    // 显示所有数据
    public void showQueue(){
        // 判断是否为空
        if(this.isEmpty()){
            System.out.println("队列为空");
        }
        for(int item : this.arr){
            System.out.print(item+"  ");
        }
    }


    // 显示队列的头部信息
    public int headQueue(){
        // 判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return this.arr[++this.front];
    }



}
