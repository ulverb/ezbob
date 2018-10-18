package com.example.operations;

public interface PerformOperation<O, R> {
    R perform(O data);
}
