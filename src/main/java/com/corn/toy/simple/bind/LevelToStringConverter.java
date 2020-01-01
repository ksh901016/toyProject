package com.corn.toy.simple.bind;

import com.corn.toy.simple.constants.Level;
import org.springframework.core.convert.converter.Converter;

public class LevelToStringConverter implements Converter<Level, String> {
    @Override
    public String convert(Level level) {
        return String.valueOf(level.intValue());
    }
}
