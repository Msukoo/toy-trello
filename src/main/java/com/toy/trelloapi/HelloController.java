package com.toy.trelloapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Hello world";
    }

    // bean 반환시에는 json형식으로 반환됨.
    @GetMapping(path = "/helloBean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world");
    }
}
