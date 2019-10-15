package com.atguitu.factory;

import com.atguitu.bean.AirPlane;

public class AirPlaneStaticFactory {

    //静态工厂
    public static AirPlane getAirPlane(String jzName){
        System.out.println("静态工厂工厂正在为你造飞机......");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("lfy");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("1273.232");
        return airPlane;
    }

}
