package com.atguigu.utils;

import java.util.List;

public class ResponseResultPlus extends ResponseResult{

    private List<Integer> info;

    public ResponseResultPlus(){
        super();
    }


    public ResponseResultPlus(List<Integer> info) {
        this.info = info;
    }

    public ResponseResultPlus(int status, String message, Object data, List<Integer> info) {
        super(status, message, data);
        this.info = info;
    }

    public List<Integer> getInfo() {
        return info;
    }

    public void setInfo(List<Integer> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResponseResultPlus{" +
                "info=" + info +
                '}';
    }
}
