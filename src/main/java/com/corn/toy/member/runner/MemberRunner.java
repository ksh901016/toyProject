package com.corn.toy.member.runner;

import com.corn.toy.member.entity.Member;
import com.corn.toy.member.entity.MemberDTO;
import com.corn.toy.member.entity.QMember;
import com.corn.toy.member.entity.QTeam;
import com.mysema.query.BooleanBuilder;
import com.mysema.query.QueryModifiers;
import com.mysema.query.SearchResults;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class MemberRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
        JPAQuery query = new JPAQuery(em);
        QMember qMember = QMember.member;
        List<Member> memberList = query.from(qMember)
                                    .where(qMember.name.eq("이름1"))
                                    .orderBy(qMember.name.desc())
                                    .list(qMember);
        System.out.println(memberList);*/

        JPAQuery query = new JPAQuery(em);
        QMember member = QMember.member;
        List<Member> members = query.from(member)
                                    .where(member.name.eq("이적").and(member.age.gt(30)))
                                    .where(member.name.eq("이적"), member.age.gt(30)) // 여러 파라미터를 넘겨도된다. (and 연산)
                                    .list(member);
        // member.age.between(30, 50);     // 나이가 30~50 사이
        // member.name.contains("이적");   // '%이적%' 검색
        // member.name.startsWith("이적"); // '이적%' 검색

        condition();
    }

    private void runPagingAndSortQuery(){
        JPAQuery query = new JPAQuery(em);
        QMember member = QMember.member;
        query.from(member)
            .where(member.age.gt(20))
            .orderBy(member.name.desc(), member.age.asc())
            .offset(10).limit(10)
            .list(member);
        // 페이징은 offset, limit를 적절히 조합해서 사용한다.

        // restrict()와 QueryModifiers 사용하기
        QueryModifiers queryModifiers = new QueryModifiers(20L, 10L); // limit, offset
        query.from(member)
            .restrict(queryModifiers)
            .list(member);

        // listResults() 사용
        SearchResults<Member> result =
        query.from(member)
            .where(member.age.gt(20))
            .offset(0).limit(10)
            .listResults(member);

        long total = result.getTotal();
        long limit = result.getLimit();
        long offset = result.getOffset();
        List<Member> resultList = result.getResults(); // 조회된 데이터
    }

    private void runJoin(){
        JPAQuery query = new JPAQuery(em);
        QMember member = QMember.member;
        QTeam team = QTeam.team;

        query.from(member)
            .join(member.team, team)
            .list(member);

        /*
        query.from(member)
            .join(member.team, team)
            .on(member.age.gt(20)) // on 사용(join 조건)
            .list(member);

        query.from(member)
            .join(member.team, team).fetch()
            .list(member);*/
    }

    public void runSubQuery(){
        JPAQuery query = new JPAQuery(em);
        QMember member = QMember.member;
        QTeam team = QTeam.team;

    }

    public void runProjection(){
        JPAQuery query = new JPAQuery(em);
        QMember member = QMember.member;
        /*
        List<String> resultList = query.from(member).list(member.name);
        resultList.stream().forEach(System.out::println);

        List<Tuple> result = query.from(member).list(member.name, member.age);
        result.stream().forEach(tuple -> {
            System.out.println("name : " + tuple.get(member.name));
            System.out.println("age : " + tuple.get(member.age));
        });*/

        List<MemberDTO> resultList =
        query.from(member).list(
                Projections.bean(MemberDTO.class, member.name.as("memberName"), member.age) // 프로퍼티 setter 접근
                // Projections.fields(MemberDTO.class, member.name.as("memberName"), member.age) // 필드 직접 접근
                // Projections.constructor(MemberDTO.class, member.name, member.age) // 생성자 사용
        );
    }

    public void condition(){
        JPAQuery query = new JPAQuery(em);
        Member condition = new Member();
        condition.setName("corn");
        condition.setAge(30);

        QMember member = QMember.member;

        BooleanBuilder builder = new BooleanBuilder();
        if(!StringUtils.isEmpty(condition.getName())){
            builder.and(member.name.contains(condition.getName()));
        }

        if(condition.getAge() != null){
            builder.and(member.age.gt(condition.getAge()));
        }

        if(!StringUtils.isEmpty(condition.getId())){
            builder.and(member.id.eq(condition.getId()));
        }

        List<Member> resutList = query.from(member)
                                    .where(builder)
                                    .list(member);
    }
}
