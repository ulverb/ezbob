package com.example.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonController {

    private PerformOperation<Data, Integer> logic;
    private WriteOutput<Integer> output;

    @Autowired
    public JsonController(PerformOperation<Data, Integer> logic, WriteOutput<Integer> output) {
        this.logic = logic;
        this.output = output;
    }

    @PostMapping("/calculate")
    public String JSONRequest(@RequestBody Data data) {
        Integer result = logic.perform(data);
        output.write(result);

        return "OK";
    }
}
