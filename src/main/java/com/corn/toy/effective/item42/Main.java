package com.corn.toy.effective.item42;

public class Main {
    public static void main(String[] args) {
        System.out.println(Operation.DIVIDE.apply(6, 2));
        System.out.println(OperationLamda.DIVIDE.apply(6, 2));
    }
}
