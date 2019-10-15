package com.atguigu.bridge;

public class Client {

    public static void main(String[] args) {
        // 样式
        Phone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.open();
        foldedPhone.close();
        foldedPhone.call();

    }


}
