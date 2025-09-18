package jpa1.main.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Customer;

public class JPAPersist1 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Customer customer = new Customer("ID00001", "PARK");
            em.persist(customer);
            em.persist(customer);
            //이런식으로 persist를 여러개를 하더라도 영속성 컨텍스트에는 이미 존재하므로 올라가지 않는다. 즉 인서트는 1번
//            ID  	    NAME  	REGDATE
//            TEST	    HONG	1757983023355
//            ID00001	PARK	1757983275671   => 하나만 생성됨.

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
