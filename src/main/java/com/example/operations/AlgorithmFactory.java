package com.example.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AlgorithmFactory {
    private ApplicationContext context;

    @Autowired
    public AlgorithmFactory(ApplicationContext context) {
        this.context = context;
    }

    public Algorithm<Operator, Integer, Integer> getAlgorithm(Data data) {
        if (data.getAlgorithm() == null)
            return this.context.getBean(ArithmeticAlg.class);

        return (Algorithm<Operator, Integer, Integer>)this.context.getBean(data.getAlgorithm());
    }
}
