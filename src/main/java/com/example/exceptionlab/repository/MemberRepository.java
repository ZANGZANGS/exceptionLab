package com.example.exceptionlab.repository;

import com.example.exceptionlab.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class MemberRepository {

    private EntityManager em;

    public MemberRepository(EntityManager em) {
        this.em = em;
    }

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Optional<Member> findByName(String name){
        try {
            Member findMember = em.createQuery("select m from Member m where m.name = :name", Member.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.of(findMember);

        }catch (NoResultException e){
            return Optional.empty();
        }

    }
}
