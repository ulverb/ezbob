package com.example.operations;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service("simple")
public class ArithmeticAlg implements Algorithm<Operator, Integer, Integer> {

    public Integer calculate(Operator operation, Integer[] numbers) {
        if (numbers == null || numbers.length == 0)
            return 0;
        if (operation == null)
            throw new RuntimeException("Operation is not defined");

        switch (operation) {
            case plus:
                return Stream.of(numbers).peek(i -> testPositiveValue(i <= 0)).mapToInt(i -> i).sum();
            case minus:
                return Stream.of(numbers).peek(i -> testPositiveValue(i <= 0)).mapToInt(i -> i * -1).sum() + 2 * numbers[0];
        }

        throw new RuntimeException("Operation is not supported");
    }

    private static void testPositiveValue(boolean b) {
        if (b) throw new RuntimeException("Value should be positive");
    }
}
