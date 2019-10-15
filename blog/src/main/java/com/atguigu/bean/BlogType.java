package com.atguigu.bean;

public class BlogType {

    private Integer id;
    private String typeName;
    // 序号
    private Integer orderNo;


    public BlogType(){

    }


    public BlogType(Integer id, String typeName, Integer orderNo) {
        this.id = id;
        this.typeName = typeName;
        this.orderNo = orderNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", orderNo=" + orderNo +
                '}';
    }
}
