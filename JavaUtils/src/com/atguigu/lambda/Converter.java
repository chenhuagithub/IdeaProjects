package com.atguigu.lambda;
@FunctionalInterface
public interface Converter<F, T> {
    /**
     *
     * @param from
     * @return
     */
    T convert(F from);



}
