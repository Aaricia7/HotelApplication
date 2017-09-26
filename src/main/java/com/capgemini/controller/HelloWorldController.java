package com.capgemini.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String home() {
        return "Hello World! fkdmlkfdmls";
    }
}