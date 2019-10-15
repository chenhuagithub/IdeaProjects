package com.atguigu.improve;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {


    private String name;
    private DeepCloneableTarget deepCloneableTarget;

    public DeepProtoType(){

    }

    public DeepProtoType(String name, DeepCloneableTarget deepCloneableTarget) {
        this.name = name;
        this.deepCloneableTarget = deepCloneableTarget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCloneableTarget getDeepCloneableTarget() {
        return deepCloneableTarget;
    }

    public void setDeepCloneableTarget(DeepCloneableTarget deepCloneableTarget) {
        this.deepCloneableTarget = deepCloneableTarget;
    }


    @Override
    public String toString() {
        return "DeepProtoType{" +
                "name='" + name + '\'' +
                ", deepCloneableTarget=" + deepCloneableTarget +
                '}';
    }

    // 深拷贝 --方式1 , 通过重写基类的clone方法实现
    @Override
    protected Object clone(){

        DeepProtoType deepProtoType = null;
        try {
            deepProtoType = (DeepProtoType) super.clone();
            deepProtoType.setDeepCloneableTarget((DeepCloneableTarget) deepCloneableTarget.clone());

        }catch (Exception e){
            e.printStackTrace();
        }


        return deepProtoType;
    }

    // 深拷贝 --方式2 , 通过对象的序列化实现, 推荐
    public Object deepClone(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            // 把对象序列化
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepProtoType copyOBJ = (DeepProtoType)ois.readObject();
            return copyOBJ;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            try {
                bos.close();
                oos.close();
                ois.close();
            }catch (Exception e2){
                e2.printStackTrace();
            }

        }


    }


}
