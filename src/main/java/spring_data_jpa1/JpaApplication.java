package spring_data_jpa1;

import spring_data_jpa1.entity.Order;
import spring_data_jpa1.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import spring_data_jpa1.specification.OrderLambdaSpec;
import spring_data_jpa1.specification.OrderSpecifitaion;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

    private static Logger logger = LoggerFactory.getLogger(JpaApplication.class);

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JpaApplication.class, args);
        OrderService orderService = context.getBean(OrderService.class);
//        RequestOrder reqOrder = new RequestOrder("테스트상품4", 1002);
//        RequestOrder reqOrder = new RequestOrder("상품5", 1005);

        try {
//            1. Create
//            orderService.saveOrder(reqOrder);

//            2. Retrieve
//            Optional<Order> findOrder1 = orderService.getOrder1(5L);
//            logger.debug(String.valueOf(findOrder1));
//            Order findOrder2 = orderService.getOrder2(5L);
//            logger.debug(String.valueOf(findOrder2));

//            3. Delete
//            Order findOrder3 = orderService.getOrder1(2L).orElseThrow(() -> new Exception("삭제할 주문이 존재하지 안습니다."));
//            orderService.deleteOrder1(findOrder3);
//            orderService.deleteOrder2(findOrder3.getOrderId());

//            4. UPDATE
//              RequestOrder reqOrder = new RequestOrder("테스트상품", 1000, 1L);
//              orderService.updateOrder(reqOrder);

//            5. JPQL로 작성한 쿼리 동작
//            List<Order> orders = orderService.findJPQLOrders(1000);
//            logger.info(orders.toString());

//            6. specification 으로 이름 like조건
            OrderSpecifitaion spec = new OrderSpecifitaion("2");
            List<Order> orders = orderService.findSpecOrders(spec);
            logger.info(orders.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }


    }

}
