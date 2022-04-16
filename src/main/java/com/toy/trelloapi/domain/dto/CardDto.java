package com.toy.trelloapi.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CardDto {
    private Long workListId;
    private Long cardId;
    private String cardTitle;
    private String cardDesc;
    private Long cardOrd;
    private String regId;
    private LocalDateTime regDtime;
    private String modId;
    private LocalDateTime modDtime;

}
