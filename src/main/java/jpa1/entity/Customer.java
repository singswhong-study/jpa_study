package jpa1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "customer")
public class Customer {

    @Id
    private String id;

    private String name;

    private long regDate;

    public Customer(String id, String name){
        this.id = id;
        this.name = name;
        this.regDate = System.currentTimeMillis();
    }

//    public Customer() {
//
//    }
//  @NoArgsConstructor 어노테이션으로 대체함.

    public static Customer sample(){
        return new Customer("TEST", "HONG");
    }

}
