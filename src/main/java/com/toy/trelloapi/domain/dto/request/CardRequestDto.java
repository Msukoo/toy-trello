package com.toy.trelloapi.domain.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "카드 DTO")
public class CardRequestDto {

    @ApiModelProperty(notes = "작업아이디", example = "1", required = true)
    @NotBlank(message = "작업아이디는 필수값 입니다.")
    private Long workListId;

    @ApiModelProperty(notes = "카드아이디", example = "1", required = true)
    @NotBlank(message = "카드아이디는 필수값 입니다.")
    private Long cardId;

    @ApiModelProperty(notes = "카드제목", example = "카드 제목 입니다.", required = true)
    @NotBlank(message = "카드제목은 필수값 입니다.")
    @Size(min = 1, max = 100)
    private String cardTitle;

    @ApiModelProperty(notes = "카드설명", example = "카드 설명/내용 입니다.", required = true)
    @Size(min = 1, max = 2000)
    private String cardDesc;

    @ApiModelProperty(notes = "카드순번", example = "1000")
    private Long cardOrd;

    @Builder
    public CardRequestDto(
            Long workListId,
            Long cardId,
            String cardTitle,
            String cardDesc,
            Long cardOrd
						 ) {
        this.workListId = workListId;
        this.cardId = cardId;
        this.cardTitle = cardTitle;
        this.cardDesc = cardDesc;
        this.cardOrd = cardOrd;
    }

}
