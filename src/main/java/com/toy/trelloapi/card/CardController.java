package com.toy.trelloapi.card;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {
    private CardDaoService cardDaoService;

    @GetMapping("/card")
    public List<Card> retrieveAllCards(){
        return cardDaoService.findAll();
    }

    @GetMapping("/card/{cardId}")
    public Card retrieveCard(@PathVariable int cardId){
        return cardDaoService.findOne(cardId);
    }

    @PostMapping(path = "/card")
    public ResponseEntity<Card> createCard(@RequestBody Card card){
        Card saveCard = cardDaoService.save(card);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{cardId}")
                .buildAndExpand(saveCard.getCardId()) //가변변수{cardId}에 값 지정
                .toUri(); //uri형태로 변경

        // return값으로 @getMapping uri 반환가능, 트래픽감소
        // localhost:8088/card/{cardId}
        // 201 status (postMapping으로 모든 응답코드를 200으로 받으면 안좋은 설계임)
        return ResponseEntity.created(location).build();
    }
}
