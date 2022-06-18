package jpabook.entity;

import jpashop.entity.Member;
import jpashop.entity.OrderItem;
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
}
