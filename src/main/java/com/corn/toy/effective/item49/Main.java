package com.corn.toy.effective.item49;


import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        checkMethod1("String이다.");
        checkMethod1(null);
    }

    // 매개변수가 유효한지 검사하자
    public static void checkMethod1(String str){
        System.out.println(Objects.requireNonNull(str, "파라미터 문자열이 null 인데..."));

        System.out.println("문자열관련 계산을 수행합니다....");
    }

    public static void checkMethod2(String str){

    }
}
