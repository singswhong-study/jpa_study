package jpa1.main.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Customer4;

public class JPACustomer4 {

    public static void main(String[] args) {
        // Entity 에 @Id generate : talbe 사용

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Customer4 c = new Customer4();
            c.setName("TEST");
            c.setRegDate(System.currentTimeMillis());

            em.persist(c);
//실행 시 id를 관리하기 위한 테이블 DDL이 실행됨

//            Hibernate:
//            create table customer_id (
//                    id_name varchar(255) not null,
//                    next_val bigint,
//                    primary key (id_name)
//    )
// customer_id 에서 select 를 해오고,
// 그리고 다음값도 지정해줘야 하므로 customer_id 에 업데이트도 한다

//            Hibernate:
//            select
//            tbl.next_val
//                    from
//            customer_id tbl
//            where
//            tbl.id_name=? for update
//            Hibernate:
//            update
//                    customer_id
//            set
//            next_val=?
//            where
//            next_val=?
//            and id_name=?

            System.out.println("================================= before commit =================================");

            tx.commit();

        } catch (Exception e ){
          tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
