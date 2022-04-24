package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.exception.CardNotFoundException;
import com.toy.trelloapi.domain.exception.WorkListNotFoundException;
import com.toy.trelloapi.domain.repository.CardQueryRepository;
import com.toy.trelloapi.domain.repository.CardRepository;
import com.toy.trelloapi.domain.repository.WorkListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final WorkListRepository workListRepository;
    private final CardRepository cardRepository;
    private final CardQueryRepository cardQueryRepository;

    public CardDto saveCard(CardDto cardDto) throws UnsupportedEncodingException {
        Optional<WorkList> optWorkList = workListRepository.findById(cardDto.getWorkListId());
        WorkList workList = optWorkList.orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));

        LocalDateTime currentDateTime = LocalDateTime.now();
        Long nextCardOrd = getNextCardOrd();
        return cardRepository.save(
                Card.builder()
                        .workList(workList)
                        .cardTitle(cardDto.getCardTitle())
                        .cardDesc(cardDto.getCardDesc())
                        .cardOrd(nextCardOrd)
                        .regId("admin")
                        .regDtime(currentDateTime)
                        .useYn(true)
                        .modId("admin")
                        .modDtime(currentDateTime)
                        .build()
        ).convertCardDto();
    }

    public CardDto getCardById(Long cardId){
        Card card = cardRepository.findById(cardId)
                                .orElseThrow(() -> new CardNotFoundException("해당 카드를 찾을 수 없습니다."));
        return card.convertCardDto();
    }

    private Long getNextCardOrd() { return cardQueryRepository.findLastCardOrd() + 1000L; }

    public CardDto updateCard(CardDto cardDto) throws UnsupportedEncodingException {
        Card card = cardRepository.findById(cardDto.getCardId())
                .orElseThrow(() -> new CardNotFoundException("해당 카드를 찾을 수 없습니다."));
        card.changeCard(cardDto, "admin");
        return card.convertCardDto();
    }
}
