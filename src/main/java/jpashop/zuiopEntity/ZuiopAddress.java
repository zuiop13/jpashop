package jpashop.zuiopEntity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class ZuiopAddress {

    private String city;
    private String street;
    private String zipcode;

    protected ZuiopAddress() {
    }

    public ZuiopAddress(String city, String street, String zipcode){
        this.city    = city;
        this.street  = street;
        this.zipcode = zipcode;
    }
}
