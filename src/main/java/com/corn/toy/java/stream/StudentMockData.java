package com.corn.toy.java.stream;

import java.util.Arrays;
import java.util.List;

public class StudentMockData {
    public static final List<Student> totalList =
            Arrays.asList(
                    new Student("깡냉", 10, Student.Sex.MALE),
                    new Student("손생", 8, Student.Sex.MALE),
                    new Student("크리스챤", 5, Student.Sex.MALE),
                    new Student("원숭이", 5, Student.Sex.MALE),
                    new Student("완두콩", 0, Student.Sex.FEMALE),
                    new Student("완두콩2", 0, Student.Sex.FEMALE)
            );

    public static final List<Student> totalList2 =
            Arrays.asList(
                    new Student("깡냉", 10, Student.Sex.MALE, Student.City.Incheon),
                    new Student("손생", 8, Student.Sex.MALE, Student.City.Seoul),
                    new Student("크리스챤", 5, Student.Sex.MALE, Student.City.Incheon),
                    new Student("원숭이", 5, Student.Sex.MALE, Student.City.Seoul),
                    new Student("완두콩", 0, Student.Sex.FEMALE, Student.City.Incheon),
                    new Student("완두콩2", 0, Student.Sex.FEMALE, Student.City.Incheon)
            );
}
