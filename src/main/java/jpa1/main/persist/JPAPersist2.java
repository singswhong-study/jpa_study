package jpa1.main.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Customer;

public class JPAPersist2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Customer customer = new Customer("ID00001", "PARK");
            em.persist(customer);

            Customer c1 = em.find(Customer.class, "ID00001");
            // ID00001 은 persist 로 영속성 컨텍스트에 존재하므로 db에 접근하지 않는다
            // tx.commit 이전에 Customer(id=ID00001, name=PARK, regDate=1757983517570) 로그가 출력된다.
            // 즉 1차 캐시에 있는 영속객체를 가져왔다.

            //log
//            Customer(id=ID00001, name=PARK, regDate=1757983517570) << commit 이전에 이미 로그됨.
//            Hibernate:
//            /* insert jpa.entity.Customer
//             */ insert
//                    into
//            customer (name, regDate, id)
//            values
//                    (?, ?, ?)


            Customer c2 = em.find(Customer.class, "ID00002");
            //이녀석은 영속성 컨텍스트에 없으므로 select쿼리가 실행된다.


            //log
//            Hibernate:
//            select
//            c1_0.id,
//                    c1_0.name,
//                    c1_0.regDate
//            from
//            customer c1_0
//            where
//            c1_0.id=?

            System.out.println(c1.toString());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
