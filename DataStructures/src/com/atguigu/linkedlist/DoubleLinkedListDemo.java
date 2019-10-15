package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        // 节点一
        HeroNode2 node1 = new HeroNode2(1, "张三", "我叫张三");
        // 节点二
        HeroNode2 node2 = new HeroNode2(2, "李四", "我叫李四");
        // 节点三
        HeroNode2 node3 = new HeroNode2(3, "吴五", "我叫吴五");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.createDoubleLinkedList(node1);
//        doubleLinkedList.createDoubleLinkedList(node2);
//        doubleLinkedList.createDoubleLinkedList(node3);
        doubleLinkedList.addDouble(node2);
        doubleLinkedList.addDouble(node3);
        doubleLinkedList.addDouble(node1);
        doubleLinkedList.showDoubleLinkedList();


    }
}


class DoubleLinkedList{
    // 头节点
    private HeroNode2 head = new HeroNode2(0, "", "");

    // 创建双向链表
    public void createDoubleLinkedList(HeroNode2 heroNode2){

        HeroNode2 temp = head;

        // 如果队列没有节点, 则直接添加
        if(this.head.next == null){
            this.head.next = heroNode2;
            heroNode2.next = this.head;
            heroNode2.previous = this.head;
            return;
        }

        // 获取双向链表的最后一个节点
        while (true){
            // 遍历完成
            if(temp.next == this.head){
                temp.next = heroNode2;
                heroNode2.next = this.head;
                heroNode2.previous = temp;
                break;
            }
            // 下一个节点
            temp = temp.next;
        }


    }


    // 按顺序添加双向链表
    public void addDouble(HeroNode2 heroNode2){
        HeroNode2 temp = this.head.next;

        // 节点找到标记
        boolean flag = false;

        if(temp == null){
            this.head.next = heroNode2;
            heroNode2.next = this.head;
            heroNode2.previous = this.head;
            return;
        }

        while (true){
            if(temp.no == heroNode2.no){
                System.out.println("已经有该顺序号的节点");
                return;
            }
            if(temp.no < heroNode2.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(true){
            if(temp.next == this.head){
                temp.next = heroNode2;
                heroNode2.next = this.head;
                heroNode2.previous = temp;
                return;
            }

            heroNode2.next = temp.next;
            heroNode2.previous = temp;
            temp.next.previous = heroNode2;
            temp.next = heroNode2;
        }

    }

    // 显示双向链表
    public void showDoubleLinkedList(){
        HeroNode2 temp = this.head;

        while (true){
            if(temp.next == this.head){
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
        }

    }

}

// 定义HeroNode类, 一个对象表示一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 previous;
    // 指向下一个节点
    public HeroNode2 next;



    public HeroNode2(int no, String name, String nickname) {
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
                '}';
    }
}

