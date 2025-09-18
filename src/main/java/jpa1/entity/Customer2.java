package jpa1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer2")
public class Customer2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //아이덴티티 전략
    private Long id;
    private String name;
    private long regDate;

    public Customer2(Long id, String name){
        this.id = id;
        this.name = name;
        this.regDate = System.currentTimeMillis();
    }


}
