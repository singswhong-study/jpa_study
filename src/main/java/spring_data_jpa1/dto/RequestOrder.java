package spring_data_jpa1.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrder {

    private Long orderId;

    private String productName;

    private int price;

    public RequestOrder(String productName, int price, Long orderId){
        this.productName = productName;
        this.price = price;
        this.orderId = orderId;
    }

    public RequestOrder(String productName, int price){
        this.productName = productName;
        this.price = price;
    }
}
