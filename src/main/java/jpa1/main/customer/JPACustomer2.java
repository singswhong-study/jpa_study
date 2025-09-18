package jpa1.main.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Customer2;

public class JPACustomer2 {

    public static void main(String[] args) {
        // Entity 에 @Id generate 사용

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Customer2 c = new Customer2();
            c.setName("LEE2");
            c.setRegDate(System.currentTimeMillis());

            em.persist(c); //1차 캐시에 저장되기 위해 database 의 id 도 알아야 하므로 insert가 된다.


            System.out.println("================================= before commit =================================");
            // insert 호출은 commit 이전에 되지만 여전히 commit 이 되어야 반영됨.

            tx.commit();

        } catch (Exception e ){
          tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
