package com.toy.trelloapi.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CardResponse {

    private Long workListId;
    private Long cardId;
    private String cardTitle;
    private String cardDesc;
    private Long cardOrd;
    private String regId;
    private LocalDateTime regDtime;
    private String modId;
    private LocalDateTime modDtime;

    @Builder
    public CardResponse(
            Long workListId,
            Long cardId,
            String cardTitle,
            String cardDesc,
            Long cardOrd,
            String regId,
            LocalDateTime regDtime,
            String modId,
            LocalDateTime modDtime

    ) {
        this.workListId = workListId;
        this.cardId = cardId;
        this.cardTitle = cardTitle;
        this.cardDesc = cardDesc;
        this.cardOrd = cardOrd;
        this.regId = regId;
        this.regDtime = regDtime;
        this.modId = modId;
        this.modDtime = modDtime;

    }

}
