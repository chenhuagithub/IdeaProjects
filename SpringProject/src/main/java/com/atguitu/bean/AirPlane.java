package com.atguitu.bean;

public class AirPlane {

    private String fdj;
    // 机翼长度
    private String yc;
    //载客量
    private Integer personNum;
    //机长名字
    private String jzName;
    //副驾驶名字
    private String fjsName;


    public String getFdj() {
        return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String getJzName() {
        return jzName;
    }

    public void setJzName(String jzName) {
        this.jzName = jzName;
    }

    public String getFjsName() {
        return fjsName;
    }

    public void setFjsName(String fjsName) {
        this.fjsName = fjsName;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "fdj='" + fdj + '\'' +
                ", yc='" + yc + '\'' +
                ", personNum=" + personNum +
                ", jzName='" + jzName + '\'' +
                ", fjsName='" + fjsName + '\'' +
                '}';
    }
}
