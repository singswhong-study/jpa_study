package jpa1.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer4")
@TableGenerator(
        name="id_generator",
        table="customer_id",
        pkColumnName = "id_name",
        pkColumnValue = "customer_id",
        valueColumnName = "next_val",
        initialValue = 0,                // 0으로 해야 1부터 시작
        allocationSize = 1              // 시퀀스와 마찬가지로, 50이라면 메모리상에서 50까지 가지고 있다가 다쓰면 +50개 조회. 하지만 디비는 대부분 증가가1 이고, 다중노드환경에서 문제가 생길 수 있으므로 1로 합시다.

)
public class Customer4 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator") //테이블타입지정
    private Long id;
    private String name;
    private long regDate;

    public Customer4(Long id, String name){
        this.id = id;
        this.name = name;
        this.regDate = System.currentTimeMillis();
    }


}
