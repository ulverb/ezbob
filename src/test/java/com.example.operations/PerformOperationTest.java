package com.example.operations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PerformOperationTest {

    @Autowired private PerformOperation<Data, Integer> logic;

    @SpyBean private AlgorithmFactory algorithmFactory;

    @Test
    void whenEmptyArrAyAndPlus_expected0() {
        assertEquals(new Integer(2), logic.perform(new Data(Operator.plus, new Integer[] {1, 1}, null)));
    }

    @Test
    void whenFactoryThrowsException_expectedRuntimeException() {
        doThrow(RuntimeException.class).when(algorithmFactory).getAlgorithm(any(Data.class));
        assertThrows(
                RuntimeException.class,
                () -> logic.perform(new Data(Operator.plus, new Integer[] {0, 0}, null))
        );
    }

}