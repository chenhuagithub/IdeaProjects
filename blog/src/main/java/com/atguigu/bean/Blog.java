package com.atguigu.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Blog {

    private Integer id;
    private String title;
    private String summary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private Integer clickHit;
    private Integer replyHit;
    private String content;
    private Integer typeId;
    private String keyWord;
    private BlogType blogType;
    private Blogger blogger;
    private Integer bloggerId;


    public Blog(){

    }

    public Blog(Integer id, String title, String summary, Date releaseDate, Integer clickHit, Integer replyHit, String content, Integer typeId, String keyWord, BlogType blogType, Blogger blogger, Integer bloggerId) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.releaseDate = releaseDate;
        this.clickHit = clickHit;
        this.replyHit = replyHit;
        this.content = content;
        this.typeId = typeId;
        this.keyWord = keyWord;
        this.blogType = blogType;
        this.blogger = blogger;
        this.bloggerId = bloggerId;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Blogger getBlogger() {
        return blogger;
    }

    public void setBlogger(Blogger blogger) {
        this.blogger = blogger;
    }

    public Integer getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Integer bloggerId) {
        this.bloggerId = bloggerId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", releaseDate=" + releaseDate +
                ", clickHit=" + clickHit +
                ", replyHit=" + replyHit +
                ", content='" + content + '\'' +
                ", typeId=" + typeId +
                ", keyWord='" + keyWord + '\'' +
                ", blogType=" + blogType +
                '}';
    }
}
