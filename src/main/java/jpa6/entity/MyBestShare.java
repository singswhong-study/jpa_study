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
@Table(name = "mybestshare")
public class MyBestShare {

    @Id
    private String userEmail;

    private String title;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "userEmail")
    private MyShare myShare;

    public MyBestShare(MyShare myShare, String title){
        this.userEmail = myShare.getEmail();
        this.myShare = myShare;
        this.title = title;
    }

}
