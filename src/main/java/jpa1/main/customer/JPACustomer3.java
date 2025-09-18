package jpa1.main.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Customer3;

public class JPACustomer3 {

    public static void main(String[] args) {
        // Entity 에 @Id generate : sequence 사용

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

//            Customer3 c = new Customer3();
//            c.setName("LEE");
//            c.setRegDate(System.currentTimeMillis());
//
//            em.persist(c); //1차 캐시에 저장되기 위해 commit 이전에 seq의 nextval을 조회한다.

            //만약 위의 과정을 100회를 한다고 한다면? 
            // allocationSize = 1 이면 select nextval 이 100번 발생
            // aloocationSize = 50 이면? ** 시퀀스가 맞지 않으면 오류 발생. 시퀀스 지우고 새로 해야됨.
            // => 지우고 다시 했을 때 시퀀스조회 3번, 현재값 151, 증가 50
            // 첫번째 : next val 을 받아옴 1
            // 두번째 : + 50 된 51까지 받아옴
            // 세번째 : 두번째에서 받아온걸 다 쓰면 다시 + 50개 받아옴.
            for(int i = 0; i < 100; i++){
                Customer3 c = new Customer3();
                c.setName("LEE" + i);
                c.setRegDate(System.currentTimeMillis());

                em.persist(c); //1차 캐시에 저장되기 위해 commit 이전에 seq의 nextval을 조회한다.
            }

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
