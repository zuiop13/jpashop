package jpashop.zuiop.repository;

import jpashop.zuiop.entity.ZuiopOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ZuiopOrderRepository {

    private final EntityManager em;

    public void save(ZuiopOrder order) {
        em.persist(order);
    }

    public ZuiopOrder findOne(Long id) {
        return em.find(ZuiopOrder.class,id);
    }

    // public List<ZuiopOrder> findAllbyCriteria(OrderSearch orderSearch);
}