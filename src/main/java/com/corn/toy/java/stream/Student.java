package com.corn.toy.java.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
    @Getter
    public enum Sex {MALE, FEMALE}
    @Getter
    public enum City {Seoul, Incheon}

    public Student(String name, int score, Sex sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    private String name;
    private int score;
    private Sex sex;
    private City city;
}
