package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    @NotNull
    @ManyToOne
    @JoinColumn(name="workListId")
    private WorkList workList;

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
