package jpa6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "myshare")
public class MyShare {

    @Id
    private String email;

    private String name;

    public MyShare(String email, String name){
        this.name = name;
        this.email = email;
    }

}
