//package com.toy.trelloapi.domain.entity;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Getter
//@Entity
//@NoArgsConstructor
//@Table(name="authMst")
//public class AuthMst {
//    @Id
//    private String authCd;
//
//    @Column(length = 100, nullable = false)
//    private String authNm;
//
//    @OneToMany(mappedBy="user", targetEntity=User.class)
//    private List<User> user;
//
//}
