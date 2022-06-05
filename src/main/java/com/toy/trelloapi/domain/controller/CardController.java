package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardRequest;
import com.toy.trelloapi.domain.dto.CardResponse;
import com.toy.trelloapi.domain.service.CardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @ApiOperation(value = "Card 저장")
    @PostMapping("")
    public ResponseEntity saveCardList(@RequestBody CardRequest cardRequest) {
        CardResponse cardResponse = cardService.saveCard(cardRequest);
        return ResponseEntity.ok().body(cardResponse);
    }

    @ApiOperation(value = "Card 수정")
    @PutMapping("/{cardId}")
    public ResponseEntity updateCard(@PathVariable Long cardId, @RequestBody CardRequest cardRequest) {
        CardResponse cardResponse = cardService.updateCard(cardId, cardRequest);
        return ResponseEntity.ok().body(cardResponse);
    }

    @ApiOperation(value = "CardId 값으로 Card return")
    @GetMapping("{cardId}")
    public ResponseEntity getCard(@PathVariable Long cardId){
        CardResponse cardResponse = cardService.getCardById(cardId);
        return ResponseEntity.ok().body(cardResponse);
    }

    // TO DO : card order update

}
