package com.toy.trelloapi.domain.dto;

import lombok.Getter;

@Getter
public class CardRequest {
    private Long cardId;
    private Long workListId;
    private String cardTitle;
    private String cardDesc;
}
