package jpashop.zuiop.entity.item;

import jpashop.zuiop.entity.ZuiopCategory;
import jpashop.zuiop.exception.NotZuiopEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter
@Setter
public class ZuiopItem {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "zuiopItems")
    private List<ZuiopCategory> categories = new ArrayList<>();


    public void addStock(int stockQuantity) {
        this.stockQuantity += stockQuantity;
    }

    public void removeStock(int stockQuantity) {
        int restStock = this.stockQuantity - stockQuantity;
        if(restStock < 0) {
            throw new NotZuiopEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
