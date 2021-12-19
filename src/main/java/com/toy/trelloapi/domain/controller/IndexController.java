package com.toy.trelloapi.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String retrieveAllCards(){
        return "trello";
    }
}
