package jpa6.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "myusercard")
public class MyUserCard {

    @Id
    private String cardNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email")
    private MyUser myuser;

    private LocalDateTime expireDate;

    public MyUserCard(String cardNo, MyUser myuser){
        this.cardNo = cardNo;
        this.myuser = myuser;
        this.expireDate = LocalDateTime.of(2026,12,31,23,59);

    }

}
