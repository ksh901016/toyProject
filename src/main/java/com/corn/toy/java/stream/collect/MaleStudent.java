package com.corn.toy.java.stream.collect;

import com.corn.toy.java.stream.Student;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
public class MaleStudent {
    // 학생들 중 남학생만 수집한다.
    private List<Student> list; // 요소를 저장할 컬렉션

    public MaleStudent(){
        list = new ArrayList<Student>();
        log.info("Thread : [ {} ] MaleStudent()", Thread.currentThread().getName());
    }

    public void accumulate(Student student){ // 요소를 수집하는 메소드
        list.add(student);
        log.info("Thread : [ {} ] accumulate()", Thread.currentThread().getName());
    }

    public void combine(MaleStudent other){ // 두 MaleStudent를 결합하는 메소드(병렬시에만 호출)
        list.addAll(other.getList());
        log.info("Thread : [ {} ] combine()", Thread.currentThread().getName());
    }

    public List<Student> getList(){
        return list;
    }
}
