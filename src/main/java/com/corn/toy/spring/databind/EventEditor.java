package com.corn.toy.spring.databind;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class EventEditor extends PropertyEditorSupport {
    // PropertyEditor 인터페이스를 구현할 수도 있지만, 구현해야하는 메서드가 너무 많음

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
