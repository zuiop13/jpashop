package jpashop.zuiop.repository;

import jpashop.zuiop.entity.item.ZuiopItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ZuiopItemRepository {

    private final EntityManager em;

    public void save(ZuiopItem zuiopItem){
        if( zuiopItem.getId() == null){
            em.persist(zuiopItem);
        } else {
            em.merge(zuiopItem);
        }
    }

    public ZuiopItem findOne(Long id){
        return em.find(ZuiopItem.class,id);
    }

    public List<ZuiopItem> findAll(){
        return em.createQuery("select i from ZuiopItem i",ZuiopItem.class).getResultList();
    }
}
