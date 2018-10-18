package com.example.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformOperationImpl implements PerformOperation<Data, Integer> {

    private AlgorithmFactory algorithmFactory;

    @Autowired
    public PerformOperationImpl(AlgorithmFactory algorithmFactory) {
        this.algorithmFactory = algorithmFactory;
    }

    @Override
    public Integer perform(Data data) {
        return algorithmFactory.getAlgorithm(data).calculate(data.getOperator(), data.getNumbers());
    }
}
