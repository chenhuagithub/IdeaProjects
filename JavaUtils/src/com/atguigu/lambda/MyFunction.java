package com.atguigu.lambda;

/**
 * @author chenhua
 */
@FunctionalInterface
public interface MyFunction {
    /**
     * 没有
     * @param num 数字
     * @return
     */
//    public Integer getValue(Integer num);

    /**
     * 加法
     * @param x
     * @param y
     * @return
     */
    public Integer add(int x, int y);
}
