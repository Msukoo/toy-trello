package com.toy.trelloapi.domain.dto;

import lombok.Getter;

@Getter
public class WorkListRequest {
    private Long workListId;
    private String workListTitle;
    private String modId;

    public void setWorkListId(Long workListId) {
        this.workListId = workListId;
    }
}
