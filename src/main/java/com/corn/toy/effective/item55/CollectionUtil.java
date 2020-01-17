package com.corn.toy.effective.item55;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class CollectionUtil {
    // 컬렉션에서 최대값을 구한다.
    public static <E extends Comparable<E>> E max(Collection<E> c){
        if(c.isEmpty()) throw new IllegalArgumentException("빈 컬렉션");

        E result = null;
        for(E e : c){
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }
        return result;
    }

    public static <E extends Comparable<E>> Optional<E> maxOptional(Collection<E> c){
        if(c.isEmpty()) return Optional.empty();

        E result = null;
        for(E e : c){
            if(result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        }
        return Optional.of(result);
    }

    public static <E extends Comparable<E>> Optional<E> maxOptionalStream(Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }
}
