package jpashop.zuiop.service;

import jpashop.zuiop.entity.ZuiopDelivery;
import jpashop.zuiop.entity.ZuiopMember;
import jpashop.zuiop.entity.ZuiopOrder;
import jpashop.zuiop.entity.ZuiopOrderItem;
import jpashop.zuiop.entity.item.ZuiopItem;
import jpashop.zuiop.repository.ZuiopItemRepository;
import jpashop.zuiop.repository.ZuiopMemberRepository;
import jpashop.zuiop.repository.ZuiopOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ZuiopOrderService {

    private final ZuiopMemberRepository zuiopMemberRepository;
    private final ZuiopItemRepository zuiopItemRepository;
    private final ZuiopOrderRepository zuiopOrderRepository;

    @Transactional
    public Long order(Long memberId,Long ItemId,int count) {

        ZuiopMember zuiopMember = zuiopMemberRepository.findOne(memberId);
        ZuiopItem zuiopItem = zuiopItemRepository.findOne(ItemId);

        //주문배송 정보 생성
        ZuiopDelivery zuiopDelivery = new ZuiopDelivery();
        zuiopDelivery.setZAddress(zuiopMember.getZAddress());

        // 주문상품 생성
        ZuiopOrderItem zuiopOrderItem = ZuiopOrderItem.createOrderItem(zuiopItem,zuiopItem.getPrice(),count);

        // 주문 생성
        ZuiopOrder zuiopOrder = ZuiopOrder.cresteOrder(zuiopMember,zuiopDelivery,zuiopOrderItem);

        // 주문 저장
        zuiopOrderRepository.save(zuiopOrder);

        return zuiopOrder.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        ZuiopOrder zuiopOrder = zuiopOrderRepository.findOne(orderId);
        zuiopOrder.cancel();
    }


/*    public List<ZuiopOrder> findOrders(ZuiopOrderSearch zuiopOrderSearch) {
        return zuiopOrderRepository.findAll(zuiopOrderSearch);
    }*/

}
