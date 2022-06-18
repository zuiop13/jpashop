package jpabook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class ZuiopBook extends ZuiopItem {
    private String author;
    private String isbn;
}
