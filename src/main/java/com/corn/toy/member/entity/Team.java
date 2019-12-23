package com.corn.toy.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Team {

    public Team(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;


    @OneToMany(mappedBy = "team") // 다대일 양방향 관계
    //@OneToMany // 일대다 단방향 관계(Team이 주인)
    //@JoinColumn(name = "TEAM_ID")
    private List<Member> memberList = new ArrayList<>();

}
