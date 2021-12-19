package com.toy.trelloapi.domain.repository;

import com.toy.trelloapi.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{

}
