package com.atguigu.bean;

public class BlogFocus {


    private Integer id;
    private Integer focusId;
    private Integer befocusId;


    public BlogFocus(){

    }

    public BlogFocus(Integer id, Integer focusId, Integer befocusId) {
        this.id = id;
        this.focusId = focusId;
        this.befocusId = befocusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFocusId() {
        return focusId;
    }

    public void setFocusId(Integer focusId) {
        this.focusId = focusId;
    }

    public Integer getBefocusId() {
        return befocusId;
    }

    public void setBefocusId(Integer befocusId) {
        this.befocusId = befocusId;
    }

    @Override
    public String toString() {
        return "BlogFocus{" +
                "id=" + id +
                ", focusId=" + focusId +
                ", befocusId=" + befocusId +
                '}';
    }
}
