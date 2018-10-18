package com.example.operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlgorithmTest {

    private Algorithm<Operator, Integer, Integer> algorithm;

    @BeforeEach
    void initTest() {
        algorithm = new ArithmeticAlg();
    }

    @Test
    void whenOperatorNull_expectedRuntimeException() {
        assertThrows(
                RuntimeException.class,
                () -> algorithm.calculate(null, new Integer[] {1,2,3})
        );
    }

    @Test
    void whenInputNull_expected0() {
        assertEquals(new Integer(0), algorithm.calculate(Operator.plus, null));
    }

    @Test
    void whenInputEmpty_expected0() {
        assertEquals(new Integer(0), algorithm.calculate(Operator.plus, new Integer[0]));
    }

}