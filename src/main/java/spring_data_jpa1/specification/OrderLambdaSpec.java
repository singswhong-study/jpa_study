package spring_data_jpa1.specification;

import org.springframework.data.jpa.domain.Specification;
import spring_data_jpa1.entity.Order;

public class OrderLambdaSpec {
    //이런식으로 구현.
    public static Specification<Order> nameLike(String value){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("productName"), "%" + value + "%"));
    }
}
