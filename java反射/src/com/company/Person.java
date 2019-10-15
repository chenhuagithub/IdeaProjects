package com.company;

public class Person {

    private String name;

    private Integer age;

    private String email;

    private String hobby;


    public Person() {
    }

    public Person(String name, Integer age, String email, String hobby) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.hobby = hobby;
    }

    public String getName() {
        System.out.println("getName....");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public void eat(String food){
        System.out.println("I eat "+food);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
