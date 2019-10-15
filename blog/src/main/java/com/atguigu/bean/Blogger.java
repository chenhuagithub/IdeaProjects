package com.atguigu.bean;

public class Blogger {

    private Integer id;
    private String userName;
    private String password;
    private String profile;
    private String nickName;
    private String sign;
    private String imageName;
    private String phone;
    private String phoneCode;


    public Blogger(){

    }


    public Blogger(Integer id, String userName, String password, String profile, String nickName, String sign, String imageName, String phone, String phoneCode) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.profile = profile;
        this.nickName = nickName;
        this.sign = sign;
        this.imageName = imageName;
        this.phone = phone;
        this.phoneCode = phoneCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }


    @Override
    public String toString() {
        return "Blogger{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profile='" + profile + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sign='" + sign + '\'' +
                ", imageName='" + imageName + '\'' +
                ", phone='" + phone + '\'' +
                ", phoneCode='" + phoneCode + '\'' +
                '}';
    }
}
