package jpa6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "myuser")
public class MyUser {

    @Id
    private String email;

    private String name;

    public MyUser(String email, String name){
        this.name = name;
        this.email = email;
    }

}
