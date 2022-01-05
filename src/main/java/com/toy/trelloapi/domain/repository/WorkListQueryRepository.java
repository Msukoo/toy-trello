package com.toy.trelloapi.domain.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WorkListQueryRepository {
    // config로 bean 설정해둠
    private final JPAQueryFactory queryFactory;
}
