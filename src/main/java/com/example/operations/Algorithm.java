package com.example.operations;

public interface Algorithm<Op, D, R> {
    R calculate(Op operation, D...data);
}
