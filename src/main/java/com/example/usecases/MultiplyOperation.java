package com.example.usecases;

public class MultiplyOperation implements Operation {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
