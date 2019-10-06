package com.corn.toy.sample;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public enum JacksonEnum {
    TEST1("TEST입니다."),
    TEST2("TEST2입니다.");

    private String text;

    @JsonCreator
    public static JacksonEnum test(String str){
        return JacksonEnum.TEST1;
    }

    @JsonValue
    public Map<String, String> getTest(){
        Map<String, String> map = new HashMap<>();
        map.put("code", JacksonEnum.TEST1.toString());
        map.put("text", TEST1.text);
        return map;
    }

}
