package com.corn.toy.effective.item42;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.function.DoubleBinaryOperator;

@AllArgsConstructor
@ToString
public enum OperationLamda {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;
    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }
}
