package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;
    @NotNull
    private Integer workListId;
    @NotNull
    private String cardTitle;
    @NotNull
    private String cardDesc;
    @NotNull
    private Long cardOrd;
    @NotNull
    private boolean useYn;

    private String regId;
    private Date regDTime;
    private String modId;
    private Date modDTime;

}
