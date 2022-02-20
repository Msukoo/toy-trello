package com.toy.trelloapi.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.QCard;
import com.toy.trelloapi.domain.entity.QWorkList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardQueryRepository implements CardRepositoryForQueryDsl{
//    public CardQueryRepository(){super(Card.class);}

    // config로 bean 설정해둠
    private final JPAQueryFactory queryFactory;

    public Long findLastCardOrd(){
        QCard card = QCard.card;

        Long cardOrd = queryFactory.select(card.cardOrd)
                .from(card)
                .orderBy(card.cardOrd.desc())
                .fetchFirst();
        if(cardOrd != null) return cardOrd;
        return 0L;
    }

}
