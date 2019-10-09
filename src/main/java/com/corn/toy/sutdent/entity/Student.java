package com.corn.toy.sutdent.entity;

import com.corn.toy.sutdent.converter.AdditionDataConverter2;
import com.corn.toy.sutdent.converter.AdditionalDataConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private String key;
    private String name;
    private int age;

    @Convert(converter = AdditionDataConverter2.class)
    private AdditionalData additionalData;
}
