package com.toy.trelloapi.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.trelloapi.domain.entity.QCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardQueryRepository implements CardRepositoryForQueryDsl{
//    public CardQueryRepository(){super(Card.class);}

    // config로 bean 설정해둠
    private final JPAQueryFactory queryFactory;

    public Long findLastCardOrd(Long listId){
        QCard card = QCard.card;

        Long cardOrd = queryFactory.select(card.cardOrd)
                .from(card)
                .orderBy(card.cardOrd.desc())
                .where(card.workList.workListId.eq(listId))
                .fetchFirst();
        if(cardOrd != null) return cardOrd;
        return 0L;
    }

}
