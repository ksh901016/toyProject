package com.corn.toy.member.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    public Member(String id, String username){
        this.id = id;
        this.username = username;
    }

    @Id
    @Column(name = "MEMBER_ID")
    private String id;

    private String username;

    // 연관 관계 맵핑
    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public void setTeam(Team team){
        this.team = team;
        if(!team.getMemberList().contains(this)){
            team.getMemberList().add(this);
        }
    }
}
