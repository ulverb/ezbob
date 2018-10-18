package com.example.operations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReadInputImpl implements ReadInput<String[], Data> {

    private ObjectMapper mapper;

    @Autowired
    public ReadInputImpl(ObjectMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public Data readInput(String[] input) {
        if (input == null || input.length <= 0)
            throw new RuntimeException("No input");

        try {
            return mapper.readValue(input[0], Data.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
