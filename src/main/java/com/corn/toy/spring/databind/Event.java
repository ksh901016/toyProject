package com.corn.toy.spring.databind;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Event {
    private Integer id;
    private String title;

    public Event(Integer id){
        this.id = id;
    }
}
