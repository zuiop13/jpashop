package jpabook.entity;

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
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "ZuiopCategoryItem")
    private List<ZuiopItem> zuiopItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private ZuiopCategory parent;

    @OneToMany(mappedBy = "parent")
    private List<ZuiopCategory> child = new ArrayList<>();
}
