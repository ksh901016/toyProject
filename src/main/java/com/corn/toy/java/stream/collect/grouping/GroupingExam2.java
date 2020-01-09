package com.corn.toy.java.stream.collect.grouping;

import com.corn.toy.java.stream.Student;
import com.corn.toy.java.stream.StudentMockData;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingExam2 {
    public static void main(String[] args) {
        List<Student> totalList = StudentMockData.totalList2;

        Stream<Student> totalStream = totalList.stream();

        Function<Student, Student.City> classifier = Student::getCity;
        Function<Student, String> mapper = Student::getName;

        Collector<String, ?, List<String>> collector1 = Collectors.toList();
        Collector<Student, ?, List<String>> collector2 = Collectors.mapping(mapper, collector1);

        Collector<Student, ?, Map<Student.City, List<String>>> collector3 =
                Collectors.groupingBy(classifier, collector2);

        Map<Student.City, List<String>> mapByCity = totalStream.collect(collector3);
        System.out.println(mapByCity);

        mapByCity = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getCity,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        )
                );
        System.out.println(mapByCity);

        mapByCity = totalList.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getCity,
                                TreeMap::new,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        )
                );
        System.out.println(mapByCity);
    }
}
