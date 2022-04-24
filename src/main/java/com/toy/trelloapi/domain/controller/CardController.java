package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.service.CardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @ApiOperation(value = "Card 저장")
    @PostMapping("")
    public ResponseEntity saveCardList(@RequestBody CardDto cardDto) throws UnsupportedEncodingException {
        cardDto = cardService.saveCard(cardDto);
        return ResponseEntity.ok().body(cardDto);
    }

    @ApiOperation(value = "Card 수정")
    @PutMapping("/{cardId}")
    public ResponseEntity updateCard(@PathVariable Long cardId, @RequestBody CardDto cardDto) throws UnsupportedEncodingException {
        cardDto.setCardId(cardId);
        cardDto = cardService.updateCard(cardDto);
        return ResponseEntity.ok().body(cardDto);
    }


    @ApiOperation(value = "CardId 값으로 Card return")
    @GetMapping("{cardId}")
    public ResponseEntity getCard(@PathVariable Long cardId){
        CardDto cardDto = cardService.getCardById(cardId);
        return ResponseEntity.ok().body(cardDto);
    }

    // TO DO : card update
    // TO DO : card order update

}
