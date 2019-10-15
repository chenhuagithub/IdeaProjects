package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {


        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 节点一
        HeroNode node1 = new HeroNode(1, "张三", "我叫张三");
        // 节点二
        HeroNode node2 = new HeroNode(2, "李四", "我叫李四");
        // 节点三
        HeroNode node3 = new HeroNode(3, "吴五", "我叫吴五");
//        singleLinkedList.add(node1);
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);

        // 显示所有节点
        singleLinkedList.showList();
//
//        HeroNode node4 = new HeroNode(3, "吴五", "我被修改了");
//        singleLinkedList.update(node4);
//        singleLinkedList.showList();

        System.out.println("=========================");

//        singleLinkedList.delete(3);
        singleLinkedList.reverseList();
        singleLinkedList.showList();


        System.out.println("==========反序输出");
        singleLinkedList.reverseShow();

    }


}


class SingleLinkedList{
    private HeroNode head = new HeroNode(0, "", "");


    // 向链表添加元素
    public void add(HeroNode heroNode){

        HeroNode temp = this.head;

        while (true){
            if(temp.next == null){
                break;
            }

            temp = temp.next;
        }

        temp.next = heroNode;
    }


    // 根据序号添加链表
    public void  addByOrder(HeroNode heroNode){
        HeroNode temp = this.head;
        // 用一个标记说明是否有该元素
        boolean flag = false;

        // 循环遍历所有节点寻找适合的节点
        while (true){
            // 判断链表是否为空
            if(temp.next == null){
                break;
            }
            // 寻找符合条件的节点(即根据序号寻找节点)
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            // 下一个节点
            temp = temp.next;
        }

        if(flag){
            System.out.println("链表顺序重复");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
//            temp.next = heroNode;
//            heroNode.next = temp.next;
        }
    }


    // 修改节点
    public void update(HeroNode heroNode){
        HeroNode temp = head;
        if(temp.next == null){
            System.out.println("链表为空~");
            return;
        }
        // 标识是否要修改的节点
        boolean flag = false;
        while (true){
            // 链表遍历完成
            if(temp == null){
                break;
            }
            if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
        }else {
            System.out.println("没有你要修改的节点");
        }

    }


    // 删除节点
    public void delete(int no){
        HeroNode temp = head;
        // 标记是否找到需要删除的节点
        boolean flag = false;
        // 判断链表是否为空
        if(temp.next == null){
            System.out.println("链表为空~");
            return;
        }

        while (true){
            // 链表遍历完成
            if(temp == null){
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            // 指向下一个节点
            temp = temp.next;
        }

        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("没有你想要删除的节点");
        }

    }


    // 节点反转
    public void reverseList(){
        // 定义一个中间头节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        // 中间转化节点
        HeroNode temp = head.next;
        // 如果队列为空或者只有一个节点, 则不用反转
        if(temp == null || temp.next == null){
            return;
        }

        // 遍历队列
        while (true){
            // 遍历完成
            if(temp == null){
                break;
            }
            if(reverseHead.next == null){
                HeroNode item = new HeroNode(temp.no, temp.name, temp.nickname);
                reverseHead.next = item;

            }else {
                HeroNode item = new HeroNode(temp.no, temp.name, temp.nickname);

                item.next = reverseHead.next;

                reverseHead.next = item;
            }

            temp = temp.next;

        }

        this.head.next = reverseHead.next;

    }


    // 从队列尾部开始输出队列
    public void reverseShow(){
        // 定义一个中间节点
        HeroNode temp = head;
        // 声明一个栈, 用于存放队列中的元素
        Stack<HeroNode> heroNodesStack = new Stack<>();
        while (true){
            if (temp == null){
                break;
            }
            if(temp.next != null){
                // 入栈
                heroNodesStack.push(temp.next);
            }

            temp = temp.next;
        }

        // 取出栈中的元素
        while (heroNodesStack.size() > 0){
            System.out.println(heroNodesStack.pop());
        }
    }

    // 显示所有节点
    public void showList(){
        HeroNode temp = this.head;
        //  判断链表是否为空
        if(temp.next == null){
            System.out.println("链表为空");
        }

        while (true){
            if(temp.next == null){
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }

    }

}


// 定义HeroNode类, 一个对象表示一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    // 指向下一个节点
    public HeroNode next;

//    public HeroNode(){
//
//    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
//                ", next=" + next +
                '}';
    }
}


