package com.corn.toy.sample;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class JacksonModel {
    private JacksonEnum test;
}
