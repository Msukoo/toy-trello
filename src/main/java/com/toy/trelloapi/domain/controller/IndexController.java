package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.entity.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

    @GetMapping("/")
    public String retrieveAllCards(){
        return "trello";
    }

//    @PostMapping("/card")
//    public List<Card> showCards(){
//
//    }

}
