package com.atguigu.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Past;
import java.util.Date;

public class Person {

    /**
     *  Hibernate Validator扩展注解类
     *      @Email: 被注解的元素必须是电子邮箱地址
     *      @Length: 被注解的字符串的大小必须在指定的范围内
     *      @NotEmpty: 被注解的字符串必须非空
     *      @Range: 被注解的元素必须在合适的范围内
     *
     *  JSR303校验框架
     *      @NotNull          注解元素必须是非空
     *      @Null             注解元素必须是空
     *      @Digits           验证数字构成是否合法
     *      @Future           验证是否在当前系统时间之后
     *      @Past             验证是否在当前系统时间之前
     *      @Max              验证值是否小于等于最大指定整数值
     *      @Min              验证值是否大于等于最小指定整数值
     *      @Pattern          验证字符串是否匹配指定的正则表达式
     *      @Size             验证元素大小是否在指定范围内
     *      @DecimalMax   验证值是否小于等于最大指定小数值
     *      @DecimalMin   验证值是否大于等于最小指定小数值
     *      @AssertTrue       被注释的元素必须为true
     *      @AssertFalse  被注释的元素必须为false
     */


    private Integer id;
    @NotNull() // 不为空
    @Length(min = 6, max = 18)
    private String name;
    @Email  // email
    private String email;
    @JsonIgnore
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past  // 必须为过去的时间 @Future: 必须是一个过去的时间
    private Date birth;
    @NumberFormat(pattern = "#,###,###.##")
    private Double salary;


    public Person(){

    }

    public Person(Integer id, String name, String email, String gender, Date birth, Double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.salary = salary;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                ", salary=" + salary +
                '}';
    }
}
