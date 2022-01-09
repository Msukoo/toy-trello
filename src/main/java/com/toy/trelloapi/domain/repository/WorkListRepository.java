package com.toy.trelloapi.domain.repository;

import com.toy.trelloapi.domain.entity.WorkList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkListRepository extends JpaRepository<WorkList, Integer> {
    List<WorkList> findAllBy();
    WorkList findByWorkListId(Integer id);
}
