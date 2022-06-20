package jpashop.zuiop.repository;

import jpashop.zuiop.entity.ZuiopMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ZuiopMemberRepository {

    @PersistenceContext
    private EntityManager em;

    /* ㅈㅈ */
    public void save(ZuiopMember member){
        em.persist(member);
    }

    /* 단거 ㅈㅎ */
    public ZuiopMember findOne(Long id) {
        return em.find(ZuiopMember.class, id);
    }

    /* 다건 ㅈㅎ */
    public List<ZuiopMember> findAll(){
        return em.createQuery("select m from ZuiopMember m",ZuiopMember.class).getResultList();
    }

    /* 이름으로 찾기 */
    public List<ZuiopMember> findByName(String name) {
        return em.createQuery("select m from ZuiopMember m where m.name = :name",ZuiopMember.class)
                .setParameter("name",name)
                .getResultList();
    }
}
