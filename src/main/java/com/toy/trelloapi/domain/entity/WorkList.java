package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "workList")
public class WorkList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workListId;
    @Column(length = 50, nullable = false)
    private String workListTitle;
    @Column(length = 50, nullable = false)
    private Integer workListOrd;
    @Column(length = 50, nullable = false)
    private boolean useYn;
    @Column(length = 50, nullable = false)
    private String regId;
    @Column
    private LocalDateTime regDtime;
    @Column(length = 50, nullable = true)
    private String modId;
    @Column
    private LocalDateTime modDtime;

    @OneToMany(mappedBy = "workList")
    private List<Card> card;

}
