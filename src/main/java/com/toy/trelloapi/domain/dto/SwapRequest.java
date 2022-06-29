package com.toy.trelloapi.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(description = "작업환 간 교환 DTO")
public class SwapRequest {
    @ApiModelProperty(notes = "교환할 작업 아이디1", example = "1", required = true)
    private Long workListId1;

    @ApiModelProperty(notes = "교환할 작업 아이디2", example = "2", required = true)
    private Long workListId2;
}
