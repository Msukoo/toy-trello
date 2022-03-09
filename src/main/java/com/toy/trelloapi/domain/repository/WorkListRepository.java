package com.toy.trelloapi.domain.repository;

import com.toy.trelloapi.domain.entity.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkListRepository extends JpaRepository<WorkList, Long>, QueryByExampleExecutor<WorkList>, WorkListForQueryDsl {
    List<WorkList> findAllBy();

    @Query("select w from WorkList w join fetch w.card")
    WorkList findByWorkListId(Long id);
}
