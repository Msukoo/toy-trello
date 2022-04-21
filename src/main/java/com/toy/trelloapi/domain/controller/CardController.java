package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.dto.request.CardRequestDto;
import com.toy.trelloapi.domain.dto.response.CardResponseDto;
import com.toy.trelloapi.domain.service.CardService;
import com.toy.trelloapi.message.Response;
import com.toy.trelloapi.message.Response2;
import com.toy.trelloapi.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
@Api(value = "/card", tags = { "Card" })
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @ApiOperation(value = "Card 저장")
    @PostMapping("")
    public ResponseEntity saveCardList(@RequestBody CardDto cardDto) throws UnsupportedEncodingException {
        cardDto = cardService.saveCard(cardDto);
        return ResponseEntity.ok().body(cardDto);
    }

    @ApiOperation(value = "Card 저장", notes = "설명 : Card 저장 <br/><br/>"
                                             + "카드 생성"
    )
    @PostMapping(value="/v1/card", produces = "application/json; charset=utf8")
    public ResponseEntity<Response<CardResponseDto>> saveCardList(@RequestBody CardRequestDto requestDto) throws UnsupportedEncodingException {

        CardResponseDto responseDto = new CardResponseDto();
        responseDto = cardService.saveCard(requestDto);
        /*return ResponseEntity.ok().body(responseDto);*/
        return ResponseEntity.ok().body(ResponseUtil.makeResponse(responseDto));
    }

    @ApiOperation(value = "CardId 값으로 Card return")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "cardId", value = "카드 ID", required = true, dataType = "Long", paramType = "query", example = "1") })
    @GetMapping("{cardId}")
    public ResponseEntity getCard(@PathVariable Long cardId){
        CardDto cardDto = cardService.getCardById(cardId);
        return ResponseEntity.ok().body(cardDto);
    }

    // TO DO : card update
    // TO DO : card order update

}
