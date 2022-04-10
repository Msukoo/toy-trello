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
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final WorkListRepository workListRepository;
    private final CardRepository cardRepository;
    private final CardQueryRepository cardQueryRepository;
    private final ModelMapper modelMapper;

    public CardDto saveCard(Long workListId, CardDto cardDto){

        LocalDateTime currentDateTime = LocalDateTime.now();

        Optional<WorkList> workList = workListRepository.findById(workListId);

        Long nextCardOrd = getNextCardOrd();

        if(workList.get() == null){
            throw new WorkListNotFoundException("리스트를 찾을 수 없습니다.");
        }
        return cardRepository.save(
                Card.builder()
                        .workList(workList.get()) //
                        .cardTitle(cardDto.getCardTitle())
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
        Card card = cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException("해당 카드를 찾을 수 없습니다."));
        return card.convertCardDto();
    }

    private Long getNextCardOrd() { return cardQueryRepository.findLastCardOrd() + 1000L; }
}
