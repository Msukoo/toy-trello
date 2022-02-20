package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.repository.CardQueryRepository;
import com.toy.trelloapi.domain.repository.CardRepository;
import com.toy.trelloapi.domain.repository.WorkListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CardService {
    private final WorkListRepository workListRepository;
    private final CardRepository cardRepository;
    private final CardQueryRepository cardQueryRepository;

    public Card saveCard(Long workListId, String cardTitle){

        LocalDateTime currentDateTime = LocalDateTime.now();

        WorkList workList = workListRepository.getById(workListId);
        if(workList == null){
            throw new NotFoundWorkListException();
            return null;
        }
        return cardRepository.save(
                Card.builder()
                        .workList(workList) //
                        .cardTitle(cardTitle)
                        .cardOrd(getNextCardOrd())
                        .regId("admin")
                        .regDTime(currentDateTime)
                        .useYn(true)
                        .modId("admin")
                        .modDTime(currentDateTime)
                        .build()
        );
    }

    public Card getCardById(int id){
        return cardRepository.findByCardId(id);
    }

    private Long getNextCardOrd() { return cardQueryRepository.findLastCardOrd() + 1000L; }
}
