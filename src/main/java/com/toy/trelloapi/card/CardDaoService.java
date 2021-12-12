package com.toy.trelloapi.card;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CardDaoService {
    private static List<Card> cards = new ArrayList<>();
    private int idCnt = 3;
    static{
        cards.add(new Card(1, 1, "test1", "test1", 100L, true, "minsu", new Date(), null, null));
        cards.add(new Card(2, 1, "test2", "test2", 200L, true, "minsu", new Date(), null, null));
        cards.add(new Card(3, 1, "test3", "test3", 300L, true, "minsu", new Date(), null, null));
    }

    public List<Card> findAll(){
        return cards;
    }

    public Card save(Card card){
        if(card.getCardId()==null){
            card.setCardId(++idCnt);
        }
        cards.add(card);
        return card;
    }

    public Card findOne(int cardId){
        for (Card card : cards){
            if(card.getCardId() == cardId){
                return card;
            }
        }
        return null;
    }
}
