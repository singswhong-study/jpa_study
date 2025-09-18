package jpa1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer3")
//@SequenceGenerator(
//        name="customer_generator",
//        sequenceName = "customer_seq",      // 시퀀스 네임
//        initialValue = 1,                   // 시퀀스 시작 값
//        allocationSize = 50                 // 시퀀스 값을 일괄 할당하기 위한 크기. 기본값은 50인데 왜? => 1로 하면 persist 할때마다 시퀀스를 매번 조회. 하지만 디비는 대부분 증가가1 이고, 다중노드환경에서 문제가 생길 수 있으므로 1로 합시다.
//)
public class Customer3 {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator") //시퀀스 전략
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name="my_seq", sequenceName = "customer_seq") //DB에서 만들어진 시퀀스를 사용할 때
    private Long id;
    private String name;
    private long regDate;

    public Customer3(Long id, String name){
        this.id = id;
        this.name = name;
        this.regDate = System.currentTimeMillis();
    }


}
