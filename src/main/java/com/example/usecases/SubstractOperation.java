package com.example.usecases;

public class SubstractOperation implements Operation {
    @Override
    public int execute(int a, int b) {
        return a - b;
    }
}
