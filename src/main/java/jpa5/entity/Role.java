package jpa5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
                                                        // ElementCollection 의 기본 fetch type 은 lazy.
    @ElementCollection(fetch =  FetchType.EAGER)        //Eager로 지정하게 되면 left join 으로 바로 조회, lazy는 해당 permission에 접근할때 조회.
    @CollectionTable(
        name = "role_perm",                             //set이 들어갈 테이블
        joinColumns = @JoinColumn(name = "roleId")      //role 의 id를 참조
    )
    @Column(name = "perm")
    private Set<String> permissions = new HashSet<>();
// 여기서 Embeddable 인 Perm table 을 넣고싶다면
//    private Set<Perm> permissions = new HashSet<>();



    public Role(String name, Set<String> permissions){
        this.name = name;
        this.permissions = permissions;
    }

    public void setPemissions(Set<String> permissions){
        this.permissions = permissions;
    }
}
