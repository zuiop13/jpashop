package jpabook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ZuiopOrderItem {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private ZuiopOrder zuiopOrder;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ZuiopItem zuiopItem;

    private int orderPrice;

    private int count;
}
