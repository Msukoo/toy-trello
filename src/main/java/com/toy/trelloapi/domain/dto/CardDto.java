package com.toy.trelloapi.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CardDto {
    private Long workListId;
    private int cardId;
    private String cardTitle;
    private String cardDesc;
    private Long cardOrd;
    private String regId;
    private LocalDateTime regDTime;
    private String modId;
    private LocalDateTime modDTime;

    @Builder
    private void CardDto(){

    }
}
