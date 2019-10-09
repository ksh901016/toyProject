package com.corn.toy.sutdent;

import com.corn.toy.sutdent.entity.AdditionalData;
import com.corn.toy.sutdent.entity.Student;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Component
public class StudentRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        AdditionalData additionalData = new AdditionalData();
        additionalData.setHeight(180d);
        additionalData.setWeight(70d);
        additionalData.setHobby("음악감상");

        Student student = new Student();
        student.setKey("1");
        student.setAge(20);
        student.setName("corn");
        student.setAdditionalData(additionalData);

        em.persist(student);
    }
}
