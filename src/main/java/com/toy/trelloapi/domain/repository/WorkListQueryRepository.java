package com.toy.trelloapi.domain.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.toy.trelloapi.domain.entity.QWorkList;
import lombok.RequiredArgsConstructor;
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

    //
    public Long findLeftWorkListOrd(Long listOrd){
        QWorkList workList = QWorkList.workList;

        Long workListOrd = queryFactory.select(workList.workListOrd)
                .from(workList)
                .where(workList.workListOrd.lt(listOrd))
                .orderBy(workList.workListOrd.desc())
                .fetchFirst();
        if(workListOrd == null) {
            return 0L;
        }
        return workListOrd;
    }


}
