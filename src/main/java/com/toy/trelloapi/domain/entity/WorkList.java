package com.toy.trelloapi.domain.entity;

import com.toy.trelloapi.domain.dto.WorkListDto;
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

    @OneToMany(mappedBy = "workList", fetch = FetchType.LAZY)
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
    ) throws UnsupportedEncodingException {
        this.workListTitle = URLDecoder.decode(workListTitle,"UTF-8");
        this.workListOrd = workListOrd;
        this.useYn = useYn;
        this.regId = regId;
        this.regDtime = regDtime;
        this.modId = modId;
        this.modDtime = modDtime;
    }

    public void changeWorkList(WorkListDto workListDto, String modId) throws UnsupportedEncodingException {
        this.workListTitle = URLDecoder.decode(workListDto.getWorkListTitle(),"UTF-8");;
        this.modId = modId;
        this.modDtime = LocalDateTime.now();
    }

    public WorkListDto convertWorkListDto(){
        return WorkListDto.builder()
                .workListId(this.workListId)
                .workListTitle(this.workListTitle)
                .workListOrd(this.workListOrd)
                .regId(this.regId)
                .regDtime(this.regDtime)
                .modId(this.modId)
                .modDtime(this.modDtime)
                .build();
    }


//    @PrePersist
//    public void regDtime() {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        this.regDtime = currentDateTime;
//    }

}
