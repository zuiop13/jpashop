package jpabook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class ZuiopAddress {
    private String city;
    private String street;
    private String zipcode;
}
