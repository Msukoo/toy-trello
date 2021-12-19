package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "workList")
public class WorkList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workListId;
    @NotNull
    private String workListTitle;
    @NotNull
    private Integer workListOrd;

    @NotNull
    private boolean useYn;
    private String regId;
    private Date regDtime;
    private String modId;
    private Date modDtime;

    @OneToMany(mappedBy = "workList")
    private List<Card> card;

}
