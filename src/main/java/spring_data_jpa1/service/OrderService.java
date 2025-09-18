package spring_data_jpa1.service;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import spring_data_jpa1.dto.RequestOrder;
import spring_data_jpa1.entity.Order;
import spring_data_jpa1.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Transactional
    public void saveOrder(RequestOrder requestOrder){
        Order order = Order.builder()
                            .productName(requestOrder.getProductName())
                            .price(requestOrder.getPrice())
                            .build();

        orderRepository.save(order);

    }

    public Optional<Order> getOrder1(Long id) throws Exception {
        //1. Optional 리턴. 없으면 Optional.empty.
        Optional<Order> findOrder = orderRepository.findById(id);
        return findOrder;
    }

    public Order getOrder2(Long id) throws Exception {
        return orderRepository.findById(id).orElseThrow(()-> new Exception("대상이 존재하지 않음"));
    }

    public void deleteOrder1(Order order){
        orderRepository.delete(order);
    }

    public void deleteOrder2(Long id){
        orderRepository.deleteById(id);
    }
    @Transactional
    public void updateOrder(RequestOrder requestOrder) {
        Order order = orderRepository.findById(requestOrder.getOrderId())
                .orElseThrow(() -> new NoSuchElementException("ID " + requestOrder.getOrderId() + "에 해당하는 주문을 찾을 수 없습니다."));
        order.changeData(requestOrder.getProductName(), requestOrder.getPrice());
//        orderRepository.save(order); 트랜잭션 종료시점에 더티체킹으로 변경되므로 save는 명시적으로 호출하지 않아도 됨.
    }

    public List<Order> findJPQLOrders(int price){
        return orderRepository.findCustomOrders(price);
    }

    public List<Order> findSpecOrders(Specification specification){
        return orderRepository.findAll(specification);
    }

}
