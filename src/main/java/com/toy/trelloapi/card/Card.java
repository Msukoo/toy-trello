package com.toy.trelloapi.card;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class Card {
    @NotNull
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
