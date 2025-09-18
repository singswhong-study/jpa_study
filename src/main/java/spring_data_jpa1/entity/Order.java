package spring_data_jpa1.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
//@Setter 영속성을 지키기 위해 setter는 X
@ToString
@NoArgsConstructor( access = AccessLevel.PROTECTED ) //기본생성자는 protected
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String productName;

    private int price;

    public void changeData(String productName, int price){
        this.productName = productName;
        this.price = price;
    }

}
