package com.corn.toy.spring.databind;

import org.springframework.core.convert.converter.Converter;

public class EventConverter {
    // Converter<Source, Target> 인터페이스를 구현 (Source -> Target 변환)
    public static class StringToEventConverter implements Converter<String, Event> {
        @Override
        public Event convert(String source) {
            return new Event(Integer.parseInt(source));
        }
    }
}
