package com.atguigu.bean;

public class BlogReply {

    private Integer id;
    private Integer responderId;
    private Integer beresponderId;
    private Integer commentId;
    private String content;
    private Blogger Responder;
    private Blogger BeResponder;

    public BlogReply(){

    }

    public BlogReply(Integer id, Integer responderId, Integer beresponderId, Integer commentId, String content) {
        this.id = id;
        this.responderId = responderId;
        this.beresponderId = beresponderId;
        this.commentId = commentId;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResponderId() {
        return responderId;
    }

    public void setResponderId(Integer responderId) {
        this.responderId = responderId;
    }

    public Integer getBeresponderId() {
        return beresponderId;
    }

    public void setBeresponderId(Integer beresponderId) {
        this.beresponderId = beresponderId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blogger getResponder() {
        return Responder;
    }

    public void setResponder(Blogger responder) {
        Responder = responder;
    }

    public Blogger getBeResponder() {
        return BeResponder;
    }

    public void setBeResponder(Blogger beResponder) {
        BeResponder = beResponder;
    }


    @Override
    public String toString() {
        return "BlogReply{" +
                "id=" + id +
                ", responderId=" + responderId +
                ", beresponderId=" + beresponderId +
                ", commentId=" + commentId +
                ", content='" + content + '\'' +
                ", Responder=" + Responder +
                ", BeResponder=" + BeResponder +
                '}';
    }
}
