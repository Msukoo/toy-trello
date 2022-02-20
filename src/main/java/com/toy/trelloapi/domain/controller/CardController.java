package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("")
    public ResponseEntity saveWorkList(@RequestBody CardDto cardDto){
        Card card = cardService.saveCard(cardDto.getWorkListId(), cardDto.getCardTitle());
        return ResponseEntity.ok().body(card.getCardId());
    }
}
