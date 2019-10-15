package com.atguitu.Imp;

import com.atguitu.inter.Calculator;
import org.springframework.stereotype.Service;


//@Service
public class MyMathCalculator implements Calculator {
    @Override
    public Integer add(int i, int j) {
        return i + j;
    }

    @Override
    public Integer sub(int i, int j) {
        return i - j;
    }

    @Override
    public Integer mul(int i, int j) {
        return i * j;
    }

    @Override
    public Integer div(int i, int j) {
        return i/j;
    }
}
