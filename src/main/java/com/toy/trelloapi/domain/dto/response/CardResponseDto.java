package com.toy.trelloapi.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.toy.trelloapi.model.PagingInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Data
@ApiModel(description = "카드 DTO")
public class CardResponseDto {

    @JsonIgnore
    private PagingInfo pagingInfo = PagingInfo.builder().build();

    @ApiModelProperty(notes = "작업아이디", example = "1")
    private Long workListId;

    @ApiModelProperty(notes = "카드아이디", example = "1")
    private Long cardId;

    @ApiModelProperty(notes = "카드제목", example = "카드 제목 입니다.")
    private String cardTitle;

    @ApiModelProperty(notes = "카드설명", example = "카드 설명 입니다.")
    private String cardDesc;

    @ApiModelProperty(notes = "카드순번", example = "1000")
    private Long cardOrd;

    @ApiModelProperty(notes = "등록자ID", example = "admin")
    private String regId;

    @ApiModelProperty(notes = "수정시간", example = "2022-04-21T08:24:13.750Z")
    private LocalDateTime regDtime;

    @ApiModelProperty(notes = "수정자ID", example = "admin")
    private String modId;

    @ApiModelProperty(notes = "수정시간", example = "2022-04-21T08:24:13.750Z")
    private LocalDateTime modDtime;

    @Builder
    public CardResponseDto(
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

    public CardResponseDto() {

    }
}
