package jpashop.zuiopEntity;

import jpashop.zuiopEntity.item.ZuiopItem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "zuiop_order_item")
@Getter
@Setter
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
}
