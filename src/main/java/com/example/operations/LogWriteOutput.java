package com.example.operations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogWriteOutput implements WriteOutput<Integer> {

    public void write(Integer data){
        log.info("The result is " + data);
    }
}
