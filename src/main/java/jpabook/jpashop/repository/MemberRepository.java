package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){ //1개 찾기용
        return em.find(Member.class,id);
    }

    public List<Member> findAll(){ //전체 찾기용
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) { //이름으로 찾기용
        return em.createQuery("select m from Member m where m.name =:name",Member.class)
                .setParameter("name",name)
                .getResultList();
    }
}
