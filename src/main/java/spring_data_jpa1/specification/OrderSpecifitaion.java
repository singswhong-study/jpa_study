package spring_data_jpa1.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import spring_data_jpa1.entity.Order;

public class OrderSpecifitaion implements Specification<Order> {

    private final String value;

    public OrderSpecifitaion(String value) {
        this.value = value;
    }

    @Override
    public Specification<Order> and(Specification<Order> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Order> or(Specification<Order> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("productName"), "%" + value + "%");
    }
}
