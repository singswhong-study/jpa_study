package jpa1.main.persist;

import jakarta.persistence.*;
import jpa1.entity.Customer;

public class JPAPersist4 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study"); // persistence xml 에 설정했던 name;
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        
        try {

            //1. 비영속 상태(NEW)
            Customer c = new Customer("ID00003", "SAM");

            //2. 영속 상태(MANAGED). find를 한다면 db에서 가져와서 영속상태가 됨.
            em.persist(c);

            //3. 준영속상태(DETACHED) - 영속상태에서 제외함.
            em.detach(c);

            //4. detach가 없다면 find시 1차캐시에서 조회됨. select는 실행되지 않음.
            //detach가 되었다면 select 날라감.
            Customer findCustomer = em.find(Customer.class, "ID00003");
            System.out.println(findCustomer.toString());
            //select 없이 Customer(id=ID00003, name=SAM, regDate=1757988254421)조회됨.


            tx.commit();

        } catch (Exception e){
//            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
