package com.toy.trelloapi.helloWorld;

import com.toy.trelloapi.card.Card;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/helloBean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable(value="name") String name){
        return new HelloWorldBean(String.format("Hello world, %s" , name));
    }
}
