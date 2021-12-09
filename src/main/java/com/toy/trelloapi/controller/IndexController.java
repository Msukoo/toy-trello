package com.toy.trelloapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    // GET
    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello world";
    }
}
