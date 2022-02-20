package com.toy.trelloapi.domain.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.trelloapi.domain.entity.QWorkList;
import com.toy.trelloapi.domain.entity.WorkList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WorkListQueryRepository implements WorkListForQueryDsl{
//    public WorkListQueryRepository(){super(WorkList.class);}

    // config로 bean 설정해둠
    private final JPAQueryFactory queryFactory;

    public Long findLastWorkListOrd(){
        QWorkList workList = QWorkList.workList;

        Long workListOrd = queryFactory.select(workList.workListOrd)
                .from(workList)
                .orderBy(workList.workListOrd.desc())
                .fetchFirst();
        if(workListOrd != null) return workListOrd;
        return 0L;
    }
}
