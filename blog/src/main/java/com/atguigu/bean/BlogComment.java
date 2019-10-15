package com.atguigu.bean;

import java.util.Date;

public class BlogComment {

    private Integer id;
    private Integer userIp;
    private Integer blogId;
    private String content;
    private Date commentDate;
    private Integer state;
    private Blogger blogger;


    public BlogComment(){

    }

    public BlogComment(Integer id, Integer userIp, Integer blogId, String content, Date commentDate, Integer state, Blogger blogger) {
        this.id = id;
        this.userIp = userIp;
        this.blogId = blogId;
        this.content = content;
        this.commentDate = commentDate;
        this.state = state;
        this.blogger = blogger;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserIp() {
        return userIp;
    }

    public void setUserIp(Integer userIp) {
        this.userIp = userIp;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "id=" + id +
                ", userIp=" + userIp +
                ", blogId=" + blogId +
                ", content='" + content + '\'' +
                ", commentDate=" + commentDate +
                ", state=" + state +
                ", blogger=" + blogger +
                '}';
    }

}
