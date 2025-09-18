package spring_data_jpa1.repository;

import org.springframework.data.jpa.domain.Specification;
import spring_data_jpa1.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends Repository<Order, Long> {
    void save(Order order);
    Optional<Order> findById(Long id);  // 없으면 empty optional
    //    Order findById(Long id);      // 없으면 null
    void delete(Order order); //내부적으로 fincById로 엔티티 조회한 뒤 delete()로 삭제
    void deleteById(Long id);
    @Query("select o from Order o where o.price > :price order by o.orderId asc")
    List<Order> findCustomOrders(@Param("price") int price);

    List<Order> findAll(Specification specification);

}
