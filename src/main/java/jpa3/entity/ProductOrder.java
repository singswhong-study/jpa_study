package jpa3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "productorder")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    private Address address;

    @AttributeOverrides({
        @AttributeOverride(name = "address1", column = @Column(name = "subAddress1")),
        @AttributeOverride(name = "address2", column = @Column(name = "subAddress2")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "subZipCode"))
    })
    @Embedded
    private Address address2;

    public ProductOrder(String title, Address address, Address subAddress){
        this.title = title;
        this.address = address;
        this.address2 = subAddress;
    }

}
