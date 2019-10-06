package com.corn.toy.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    // 연관 관계 맵핑
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;
}
