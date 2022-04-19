package com.toy.trelloapi.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkListDto {

    private Long workListId;
    private String workListTitle;
    private Long workListOrd;
    private String regId;
    private LocalDateTime regDtime;
    private String modId;
    private LocalDateTime modDtime;
    private List<CardDto> cardList;

    @Builder
    public WorkListDto(
            Long workListId,
            String workListTitle,
            Long workListOrd,
            String regId,
            LocalDateTime regDtime,
            String modId,
            LocalDateTime modDtime
    ){
        this.workListId = workListId;
        this.workListTitle = workListTitle;
        this.workListOrd = workListOrd;
        this.regId = regId;
        this.regDtime = regDtime;
        this.modId = modId;
        this.modDtime = modDtime;
    }

}
