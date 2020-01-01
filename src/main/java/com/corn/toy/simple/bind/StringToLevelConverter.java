package com.corn.toy.simple.bind;

import com.corn.toy.simple.constants.Level;
import org.springframework.core.convert.converter.Converter;

public class StringToLevelConverter implements Converter<String, Level> {
    @Override
    public Level convert(String s) {
        return Level.valueOf(Integer.parseInt(s));
    }
}
