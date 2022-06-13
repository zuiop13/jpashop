package jpabook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ZuiopDelivery {
    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "zuiopDelivery")
    private ZuiopOrder zuiopOrder;

    @Embedded
    private ZuiopAddress ZAddress;

    private ZuiopDeliveryStatus zuiopDeliveryStatus;
}
