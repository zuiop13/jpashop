package jpashop.zuiop.entity;

import jpashop.chris.entity.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ZuiopOrder {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private ZuiopMember zuiopMember;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private ZuiopDelivery zuiopDelivery;

    @OneToMany(mappedBy = "zuiopOrder", cascade = CascadeType.ALL)
    private List<ZuiopOrderItem> zuiopOrderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private ZuiopOrderStatus status;

    public void setMember(ZuiopMember zuiopMember){
        this.zuiopMember = zuiopMember;
        zuiopMember.getZuiopOrders().add(this);
    }

    public void setDelivery(ZuiopDelivery zuiopDelivery){
        this.zuiopDelivery = zuiopDelivery;
        zuiopDelivery.setZuiopOrder(this);
    }

    public void addOrderItem(ZuiopOrderItem orderItem){
        this.zuiopOrderItems.add(orderItem);
        orderItem.setZuiopOrder(this);
    }

    /* 생성 메서드 */
    public static ZuiopOrder cresteOrder(ZuiopMember zuiopMember,ZuiopDelivery zuiopDelivery,ZuiopOrderItem... zuiopOrderItems) {
        ZuiopOrder zuiopOrder = new ZuiopOrder();
        zuiopOrder.setMember(zuiopMember);
        zuiopOrder.setDelivery(zuiopDelivery);
        for (ZuiopOrderItem zuiopOrderItem : zuiopOrderItems) {
            zuiopOrder.addOrderItem(zuiopOrderItem);
        }
        zuiopOrder.setStatus(ZuiopOrderStatus.ORDER);
        zuiopOrder.setOrderDate(LocalDateTime.now());
        return zuiopOrder;
    }

    /* 주문 취소 */
    public void cancel() {
        if(zuiopDelivery.getZuiopDeliveryStatus() == ZuiopDeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(ZuiopOrderStatus.CANCEL);
        for (ZuiopOrderItem zuiopOrderItem: zuiopOrderItems) {
            zuiopOrderItem.cancel();
        }
    }

    /* 젗제 주문 가격 조회*/
    public int getTotalPrice(){
        int totalPrice = 0;
        for (ZuiopOrderItem zuiopOrderItem : zuiopOrderItems) {
            totalPrice += zuiopOrderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
