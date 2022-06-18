package jpabook.entity;

import jpashop.entity.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ZuiopCategory {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "ZuiopCategoryItem",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<ZuiopItem> zuiopItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ZuiopCategory parent;

    @OneToMany(mappedBy = "parent")
    private List<ZuiopCategory> child = new ArrayList<>();

/*    public void setZuiopCategory(ZuiopCategory zuiopCategory) {
        this.parent = zuiopCategory;
        zuiopCategory.getChild().add(this);
    }*/

    //==연관관계 메서드==//
    public void addChildCategory(ZuiopCategory child){
        this.child.add(child);
        child.setParent(this);
    }
}
