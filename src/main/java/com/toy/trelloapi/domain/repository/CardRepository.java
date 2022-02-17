package com.toy.trelloapi.domain.repository;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>, QueryByExampleExecutor<Card>, CardRepositoryForQueryDsl{
    List<Card> findAllBy();
    Card findByCardId(Integer id);
}
