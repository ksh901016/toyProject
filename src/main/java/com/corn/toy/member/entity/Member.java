package com.corn.toy.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private Integer age;

    @ManyToOne
    private Team team;
}
