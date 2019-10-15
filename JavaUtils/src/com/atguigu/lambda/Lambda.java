package com.atguigu.lambda;

import java.util.function.Consumer;

/**
 * @author chenhua
 */
public class Lambda {
    public static void main(String[] args) {

        Converter<String, Integer> converter = param -> {
            System.out.println("fjljfljflj");
            return Integer.valueOf(param);
        };
        Integer convert = converter.convert("3746372");
        System.out.println(convert);

    }



}
