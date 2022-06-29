package com.toy.trelloapi.domain.entity;

import com.toy.trelloapi.domain.dto.WorkListRequest;
import com.toy.trelloapi.domain.dto.WorkListResponse;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "workList")
public class WorkList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workListId;

    @Column(length = 100, nullable = false)
    private String workListTitle;

    @Column(nullable = false)
    private Long workListOrd;

    @Column(columnDefinition = "boolean default true")
    private boolean useYn;

    @Column(length = 20, nullable = false)
    private String regId;

    @Column
    private LocalDateTime regDtime;

    @Column(length = 20, nullable = true)
    private String modId;

    @Column
    private LocalDateTime modDtime;

    @Setter
    @OneToMany(mappedBy = "workList", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Card> card;

    @Builder
    public WorkList(
                    String workListTitle,
                    Long workListOrd,
                    boolean useYn,
                    String regId,
                    LocalDateTime regDtime,
                    String modId,
                    LocalDateTime modDtime
    ) {
        try {
            this.workListTitle = URLDecoder.decode(workListTitle,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        this.workListOrd = workListOrd;
        this.useYn = useYn;
        this.regId = regId;
        this.regDtime = regDtime;
        this.modId = modId;
        this.modDtime = modDtime;
    }

    public void changeWorkList(WorkListRequest workListRequest, String modId) {
        try {
            this.workListTitle = URLDecoder.decode(workListRequest.getWorkListTitle(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        this.modId = modId;
        this.modDtime = LocalDateTime.now();
    }

    public WorkListResponse convertWorkListDto(){
        return WorkListResponse.builder()
                .workListId(this.workListId)
                .workListTitle(this.workListTitle)
                .workListOrd(this.workListOrd)
                .regId(this.regId)
                .regDtime(this.regDtime)
                .modId(this.modId)
                .modDtime(this.modDtime)
                .build();
    }

    public void changeOrd(Long destinationOrd, String modId) {
        this.workListOrd = destinationOrd;
        this.modId = modId;
        this.modDtime = LocalDateTime.now();
    }

    public void swapWorkListOrd(Long newOrd) {
        this.workListOrd = newOrd;
    }


//    @PrePersist
//    public void regDtime() {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        this.regDtime = currentDateTime;
//    }

}
