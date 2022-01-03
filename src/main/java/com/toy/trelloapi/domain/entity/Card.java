package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    @NotNull
    @ManyToOne
    @JoinColumn(name="workListId")
    private WorkList workList;

    @Column(length = 50, nullable = false)
    private String cardTitle;
    @Column(length = 50, nullable = false)
    private String cardDesc;
    @Column(length = 50, nullable = false)
    private Long cardOrd;
    @Column(length = 50, nullable = false)
    private boolean useYn;
    @Column(length = 50, nullable = false)
    private String regId;
    @Column
    private Date regDTime;
    @Column(length = 50, nullable = false)
    private String modId;
    @Column
    private Date modDTime;

}
