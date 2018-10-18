package com.example.operations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorMain implements CommandLineRunner {


    public static void main(String[] args){
        SpringApplication.run(CalculatorMain.class, args);
    }

    @Bean
    public ObjectMapper getJsonMapper() {
        return new ObjectMapper();
    }

    @Autowired private ReadInput<String[], Data> in;
    @Autowired private PerformOperation<Data, Integer> logic;
    @Autowired private WriteOutput<Integer> output;

    @Override
    public void run(String[] args) throws Exception {
        Data data = in.readInput(args);
        Integer result = logic.perform(data);
        output.write(result);
    }
}
