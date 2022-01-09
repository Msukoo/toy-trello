package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.exception.CardNotFoundException;
import com.toy.trelloapi.domain.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final CardService cardService;

    @GetMapping("/")
    public String trello(){
        return "trello";
    }

    @GetMapping("/card/{id}")
    public Card showCards(@PathVariable int id){
        Card card = cardService.getCardById(id);
        if(card == null){
            throw new CardNotFoundException(String.format("ID[%s] not found", id));
        }
        return card;
    }

}
