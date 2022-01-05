package com.toy.trelloapi.domain.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.QCard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CardQueryRepository {
    // config로 bean 설정해둠
    private final JPAQueryFactory queryFactory;

//    public List<Card> getList(String name) {
//
//        Class<QCard> card = QCard.class;
//    }

}
