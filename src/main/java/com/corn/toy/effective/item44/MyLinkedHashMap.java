package com.corn.toy.effective.item44;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class MyLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    private BiPredicate<Map, Map.Entry> predicate; // 표준 함수형 인터페이스인 BiPredicate 변환하는 것이 좋다.

    public MyLinkedHashMap(BiPredicate<Map, Map.Entry> predicate){
        this.predicate = predicate;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return predicate.test(this, eldest);
        // return size() > 100;
    }
}
