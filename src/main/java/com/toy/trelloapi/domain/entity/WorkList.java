package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "workList")
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
    ){
        this.workListTitle = workListTitle;
        this.workListOrd = workListOrd;
        this.useYn = useYn;
        this.regId = regId;
        this.regDtime = regDtime;
        this.modId = modId;
        this.modDtime = modDtime;
    }

    public void changeWorkList(String workListTitle, String modId, LocalDateTime modDtime) {
        this.workListTitle = workListTitle;
        this.modId = modId;
        this.modDtime = modDtime;
    }


//    @PrePersist
//    public void regDtime() {
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        this.regDtime = currentDateTime;
//    }

}
