package jpashop.zuiop.entity;

import jpashop.zuiop.entity.item.ZuiopItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "zuiop_order_item")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ZuiopOrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private ZuiopOrder zuiopOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private ZuiopItem zuiopItem;

    private int orderPrice;
    private int count;

    /* 생성 메서드 */
    public static ZuiopOrderItem createOrderItem(ZuiopItem zuiopItem,int orderPrice,int count) {
        ZuiopOrderItem zuiopOrderItem = new ZuiopOrderItem();
        zuiopOrderItem.setZuiopItem(zuiopItem);
        zuiopOrderItem.setOrderPrice(orderPrice);
        zuiopOrderItem.setCount(count);
        zuiopItem.removeStock(count);
        return zuiopOrderItem;
    }

    /* 취소 하면, 아이템 수량 초기화 - 취소된 만큼 넣음 */
    public void cancel() {
        getZuiopItem().addStock(count);
    }

    /* 총 가격 */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
