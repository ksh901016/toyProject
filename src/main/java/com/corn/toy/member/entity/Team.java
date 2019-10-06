package com.corn.toy.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;

    private String name;
}
