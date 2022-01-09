package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.repository.CardQueryRepository;
import com.toy.trelloapi.domain.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardQueryRepository cardQueryRepository;

    public Card getCardById(int id){
        return cardRepository.findByCardId(id);
    }
}
