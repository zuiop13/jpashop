package jpashop.chris.repository;

import jpashop.chris.entity.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
/**
 * @Repository 를 까보면, @Component가 있음
 * 스프링부트의 기본 동작 원리가 Application 하위에 존재하는 모든 component를 스캔해서 빈을 주입함.
 * 그래서 Repository 어노테이션을 달면 해당 클래스가 등록됨
 */
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from MEMBER m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from MEMBER m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
