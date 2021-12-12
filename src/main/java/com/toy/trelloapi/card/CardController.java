package com.toy.trelloapi.card;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {
    private CardDaoService cardDaoService;

    @GetMapping("/cards")
    public List<Card> retrieveAllCards(){
        return cardDaoService.findAll();
    }

    @GetMapping("/cards/{cardId}")
    public Card retrieveCard(@PathVariable int cardId){
        return cardDaoService.findOne(cardId);
    }
}
