package com.toy.trelloapi.domain.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

//    @NotNull
//    @ManyToOne
//    @JoinColumn(name="authCd")
//    private AuthMst AuthMst;

    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String userNm;


}
