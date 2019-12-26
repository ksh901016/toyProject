package com.corn.toy.effective.item43;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Function<String, String> function = String::toLowerCase;
        System.out.println(function.apply("ABC"));
    }

}
