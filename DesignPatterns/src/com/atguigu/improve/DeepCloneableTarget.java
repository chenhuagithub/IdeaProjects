package com.atguigu.improve;

import java.io.*;

public class DeepCloneableTarget implements Serializable, Cloneable {

    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(){

    }

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }

    @Override
    public String toString() {
        return "DeepCloneableTarget{" +
                "cloneName='" + cloneName + '\'' +
                ", cloneClass='" + cloneClass + '\'' +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneableTarget deepCloneableTarget =(DeepCloneableTarget) super.clone();
        return deepCloneableTarget;
    }


}
