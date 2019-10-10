package com.corn.toy.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingBy {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("강",5),
                new Student("강", 2),
                new Student("이", 3),
                new Student("개",4));

        //Map<String, Student> studentMap =
        Map<String, List<Student>> list =
        studentList.stream()
                .collect(Collectors.groupingBy(Student::getName));

        System.out.println(list);
    }

}
