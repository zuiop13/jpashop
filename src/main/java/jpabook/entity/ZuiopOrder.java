package jpabook.entity;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private ZuiopMember zuiopMember;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private ZuiopDelivery zuiopDelivery;

    @OneToMany(mappedBy = "zuiopOrder")
    private List<ZuiopOrderItem> zuiopOrderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    private ZuiopOrderStatus status;
}
