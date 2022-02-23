package com.toy.trelloapi.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class WorkListDto {
    private Long workListId;
    private String workListTitle;
    private Long workListOrd;
    private boolean useYn;
    private String regId;
    private LocalDateTime regDtime;
    private String modId;
    private LocalDateTime modDtime;

}
