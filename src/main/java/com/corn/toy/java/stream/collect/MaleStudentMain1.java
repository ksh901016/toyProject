package com.corn.toy.java.stream.collect;

import com.corn.toy.java.stream.Student;
import com.corn.toy.java.stream.StudentMockData;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MaleStudentMain1 {
    public static void main(String[] args) {
        List<Student> totalList = StudentMockData.totalList;

        Stream<Student> totalStream = totalList.stream();
        Stream<Student> maleStream = totalStream.filter(s -> s.getSex() == Student.Sex.MALE);

        // 첫 번째 매개변수 공급자(Supplier)
        Supplier<MaleStudent> supplier = () -> new MaleStudent();
        // 두 번째 매개변수 누산자(XXXConsumer<R, ? super T>)
        BiConsumer<MaleStudent, Student> accumulator = (ms, s) -> ms.accumulate(s);
        // 세 번째 매개변수 결합자(BiConsumer<R,R>)
        BiConsumer<MaleStudent, MaleStudent> combiner = (ms1, ms2) -> ms1.combine(ms2);

        MaleStudent maleStudent = maleStream.collect(supplier, accumulator, combiner);

        maleStudent = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(
                        () -> new MaleStudent(),
                        (r, t) -> r.accumulate(t),
                        (r1, r2) -> r1.combine(r2)
                );

        maleStudent = totalList.stream()
                .filter(s -> s.getSex() == Student.Sex.MALE)
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);
        System.out.println(maleStudent.getList());
    }
}
