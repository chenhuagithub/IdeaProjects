package com.atguigu.improve;

public class Client {

    public static void main(String[] args) {

        DeepProtoType deepProtoType = new DeepProtoType();
        DeepCloneableTarget deepCloneableTarget = new DeepCloneableTarget("陈话", "陈话克隆类");
        deepProtoType.setName("宋江");
        deepProtoType.setDeepCloneableTarget(deepCloneableTarget);

        System.out.println(deepProtoType);
        System.out.println(deepProtoType.getDeepCloneableTarget().hashCode());
//        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.clone();
        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.deepClone();
        System.out.println(deepProtoType1);
        System.out.println(deepProtoType1.getDeepCloneableTarget().hashCode());


        deepCloneableTarget.setCloneName("嘿嘿");


        System.out.println(deepProtoType);
        System.out.println(deepProtoType.getDeepCloneableTarget().hashCode());
        System.out.println(deepProtoType1);
        System.out.println(deepProtoType1.getDeepCloneableTarget().hashCode());


//        Sheep sheep = new Sheep("tom", 1, "白色");
//        Sheep friend = new Sheep("tom的朋友", 34, "黑色");
//        sheep.setFriend(friend);
//
//        Sheep sheep1 = (Sheep) sheep.clone();
//
//        System.out.println(sheep.getFriend().hashCode());
//        System.out.println(sheep1.getFriend().hashCode());
//        System.out.println(sheep.getName().hashCode());
//        System.out.println(sheep1.getName().hashCode());
//
//
//        System.out.println("sheep:"+sheep);
//        System.out.println("sheep1:"+sheep1);
//
//        friend.setName("陈华");
//
//        System.out.println("sheep:"+sheep);
//        System.out.println("sheep1:"+sheep1);


    }

}
