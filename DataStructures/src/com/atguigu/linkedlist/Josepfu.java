package com.atguigu.linkedlist;

public class Josepfu {

    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.addBoy(10);
        circleLinked.showBoy();
    }

}


class CircleLinked{

    private Boy first = null;


    public void addBoy(int nums){

        // 如果nums小于1, 则退出程序
        if(nums < 1){
            System.out.println("链表至少需要1个人");
            return;
        }

        // 中间辅助节点
        Boy curBoy = null;

        // 循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            if(i == 1){
                this.first = new Boy(i);
                this.first.setNext(this.first);
                curBoy = this.first;
            }else {
                Boy boy = new Boy(i);
                curBoy.setNext(boy);
                boy.setNext(this.first);
                curBoy = boy;
            }

        }

    }


    public void showBoy(){

        Boy temp = this.first;

        while (true){
            System.out.println(temp.getNo());
            if(temp.getNext() == this.first){
                break;
            }
            temp = temp.getNext();
        }


    }



}



class Boy{

    private int no;
    private Boy next;


    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}