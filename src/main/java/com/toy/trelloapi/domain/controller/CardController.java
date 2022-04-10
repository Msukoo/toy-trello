package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("")
    public ResponseEntity saveCardList(@RequestBody CardDto cardDto){
        Card card = cardService.saveCard(cardDto.getWorkListId(), cardDto);
        return ResponseEntity.ok().body(card.getCardId());
    }

    @GetMapping("{cardId}")
    public ResponseEntity getCard(@PathVariable Long cardId){
        CardDto cardDto = cardService.getCardById(cardId);
        return ResponseEntity.ok().body(cardDto);
    }

    // TO DO : card update
    // TO DO : card order update

}
