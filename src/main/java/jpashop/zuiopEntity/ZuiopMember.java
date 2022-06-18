package jpashop.zuiopEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ZuiopMember {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private ZuiopAddress ZAddress;

    @OneToMany(mappedBy = "zuiopMember")
    private List<ZuiopOrder> zuiopOrders = new ArrayList<>();
}
