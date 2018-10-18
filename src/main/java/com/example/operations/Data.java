package com.example.operations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private Operator operator;
    private Integer[] numbers;
    private String algorithm;
}
