package com.toy.trelloapi.domain.entity;

import com.toy.trelloapi.domain.dto.CardDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="workListId")
    private WorkList workList;

    @Column(length = 100, nullable = false)
    private String cardTitle;

    @Column(nullable = false)
    private Long cardOrd;

    @Column
    private String cardDesc;

    @Column(columnDefinition = "boolean default true")
    private boolean useYn;

    @Column(length = 20, nullable = false)
    private String regId;

    @Column
    private LocalDateTime regDtime;

    @Column(length = 20, nullable = false)
    private String modId;

    @Column
    private LocalDateTime modDtime;

    @Builder
    public Card(
                WorkList workList,
                String cardTitle,
                String cardDesc,
                Long cardOrd,
                boolean useYn,
                String regId,
                LocalDateTime regDtime,
                String modId,
                LocalDateTime modDtime
    ) throws UnsupportedEncodingException {
        this.workList = workList;
        this.cardTitle = URLDecoder.decode(cardTitle,"UTF-8");
        this.cardDesc = cardDesc;
        this.cardOrd = cardOrd;
        this.useYn = useYn;
        this.regId = regId;
        this.regDtime = regDtime;
        this.modId = modId;
        this.modDtime = modDtime;
    }

    public CardDto convertCardDto(){
        return CardDto.builder()
                .cardId(this.cardId)
                .workListId(this.workList.getWorkListId())
                .cardTitle(this.cardTitle)
                .cardDesc(this.cardDesc)
                .cardOrd(this.cardOrd)
                .regId(this.regId)
                .regDtime(this.regDtime)
                .modId(this.modId)
                .modDtime(this.modDtime)
                .build();
    }
}
