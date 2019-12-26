package com.corn.toy.effective.item42;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public enum Operation {
    PLUS("+"){
        public double apply(double x, double y){ return x+y; }
    },
    MINUS("-"){
        public double apply(double x, double y){ return x-y; }
    },
    TIMES("*"){
        public double apply(double x, double y){ return x*y; }
    },
    DIVIDE("/"){
        public double apply(double x, double y){ return x/y; }
    };

    private final String symbol;
    public abstract double apply(double x, double y);
}
