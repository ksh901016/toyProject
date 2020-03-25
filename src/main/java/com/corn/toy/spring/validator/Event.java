package com.corn.toy.spring.validator;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class Event {
    Integer id;
    @NotEmpty
    String title;
}
