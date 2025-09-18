package jpa1.main.persist;

import jakarta.persistence.*;
import jpa1.entity.Customer;

import java.util.List;

public class JPAPersist3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study"); // persistence xml 에 설정했던 name;
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        
        try {

            //1. 비영속 상태(NEW)
            Customer c = new Customer("ID00002", "LEE");

            //2. 영속 상태(MANAGED). find를 한다면 db에서 가져와서 영속상태가 됨.
            em.persist(c);

            //여기서 commit하지 않고 flush를 한다면?
//            em.flush();
//            Hibernate:
//            /* insert jpa.entity.Customer */
//            insert
//            into
//            customer (name, regDate, id)
//            values
//            (?, ?, ?)
// insert 는 로그됐지만 실제 디비는


//            ID  	    NAME  	REGDATE
//            TEST	    HONG	1757983023355
//            ID00001	PARK	1757983275671
// 등록되지 않았다.
// 고로 commit을 해야한다.

// 여기서 JPQL을 사용하면
            Query q = em.createQuery("select c from Customer c", Customer.class);
            List<Customer> customerList = q.getResultList();
            System.out.println(customerList);
// flush는 되어서 로그상에는
//            [Customer(id=TEST, name=HONG, regDate=1757983023355), Customer(id=ID00001, name=PARK, regDate=1757983275671), Customer(id=ID00002, name=LEE, regDate=1757987939705)]
// ID00002, LEE는 존재하지만 DB상에는 없다.

//            ID  	    NAME  	REGDATE
//            TEST	    HONG	1757983023355
//            ID00001	PARK	1757983275671
// 결국commit 을 진행해야 변경이 된다.


            tx.commit();

        } catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
