package com.example.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformOperationImpl implements PerformOperation<Data, Integer> {

    private Algorithm<Operator, Integer, Integer> algorithm;

    @Autowired
    public PerformOperationImpl(Algorithm<Operator, Integer, Integer> algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public Integer perform(Data data) {
        return algorithm.calculate(data.getOperator(), data.getNumbers());
    }
}
