package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.CardRequest;
import com.toy.trelloapi.domain.dto.CardResponse;
import com.toy.trelloapi.domain.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
@Api(value = "/card", tags = { "Card" })
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @ApiOperation(value = "Card 저장", notes = "설명 : Card 저장 <br/><br/>"
                                             + "카드 생성"
    )
    @PostMapping("")
    public ResponseEntity saveCardList(@RequestBody CardRequest cardRequest) {
        CardResponse cardResponse = cardService.saveCard(cardRequest);
        return ResponseEntity.ok().body(cardResponse);
    }

//    @ApiOperation(value = "Card 저장", notes = "설명 : Card 저장 <br/><br/>"
//                                             + "카드 생성"
//    )
//    @PostMapping(value="/v1/card", produces = "application/json; charset=utf8")
//    public ResponseEntity<Response<CardResponseDto>> cardListCreate(@RequestBody CardRequestDto.CardCreate requestDto) throws UnsupportedEncodingException {
//
//        CardResponseDto responseDto = cardService.saveCard(requestDto);
//        /*return ResponseEntity.ok().body(responseDto);*/
//        return ResponseEntity.ok().body(ResponseUtil.makeResponse(responseDto));
//    }

    @ApiOperation(value = "Card 수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardId", value = "카드 ID", required = true, dataType = "Long", paramType = "path", example = "1")
    })
    @PutMapping("/{cardId}")
    public ResponseEntity updateCard(@PathVariable Long cardId, @RequestBody CardRequest cardRequest) {
        CardResponse cardResponse = cardService.updateCard(cardId, cardRequest);
        return ResponseEntity.ok().body(cardResponse);
    }

//    @ApiOperation(value = "Card 수정")
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "cardId", value = "카드 ID", required = true, dataType = "Long", paramType = "path", example = "1")
//    })
//    @PutMapping("/v1/{cardId}")
//    public ResponseEntity<Response2<CardEmptyResponseDto, ?>> cardMofidy(@PathVariable Long cardId, @RequestBody CardRequestDto.CardModify requestDto) throws Exception {
//        CardEmptyResponseDto responseDto = new CardEmptyResponseDto();
//        try {
//            requestDto.setCardId(cardId);
//            cardService.cardModify(requestDto);
//        } catch (ApiException apiException){
//            throw new ApiException(apiException.getStatus(), apiException.getErrorCode(), "", apiException.getGuideMessage());
//        } catch (Exception exception){
//            throw new Exception();
//        }
//        return ResponseEntity.ok().body(Response2Util.makeResponse(responseDto.getResponseCode(), responseDto));
//    }

    @ApiOperation(value = "CardId 값으로 Card return")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "cardId", value = "카드 ID", required = true, dataType = "Long", paramType = "path", example = "1")
    })
    @GetMapping("{cardId}")
    public ResponseEntity getCard(@PathVariable Long cardId){
        CardResponse cardResponse = cardService.getCardById(cardId);
        return ResponseEntity.ok().body(cardResponse);
    }

    // TO DO : card order update

}
