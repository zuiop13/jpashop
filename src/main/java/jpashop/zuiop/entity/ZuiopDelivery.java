package jpashop.zuiop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class ZuiopDelivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "zuiopDelivery", fetch = LAZY)
    private ZuiopOrder zuiopOrder;

    @Embedded
    private ZuiopAddress ZAddress;

    @Enumerated(EnumType.STRING)
    private ZuiopDeliveryStatus zuiopDeliveryStatus;
}
