package com.toy.trelloapi.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class WorkListDto {
    private Long workListId;
    private String workListTitle;
    private Long workListOrd;
    private boolean useYn;
    private String regId;
    private LocalDateTime regDtime;
    private String modId;
    private LocalDateTime modDtime;
    private List<CardDto> cardList;

}
