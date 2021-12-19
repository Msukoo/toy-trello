package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Entity
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

}
