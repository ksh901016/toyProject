package com.corn.toy.java.stream.collect.grouping;

import com.corn.toy.java.stream.Student;
import com.corn.toy.java.stream.StudentMockData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingExam1 {
    public static void main(String[] args) {
        List<Student> totalList = StudentMockData.totalList;

        Stream<Student> totalStream = totalList.stream();
        Function<Student, Student.Sex> classifier = Student::getSex;
        Collector<Student, ?, Map<Student.Sex, List<Student>>> collector =
                Collectors.groupingBy(classifier);

        Map<Student.Sex, List<Student>> mapBySex = totalStream.collect(collector);
        System.out.println(mapBySex);

        mapBySex = totalList.stream()
                .collect(Collectors.groupingBy(Student::getSex));
        System.out.println(mapBySex);
    }
}
