package jpa3.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa3.entity.Address;
import jpa3.entity.ProductOrder;

public class Embeddable {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Address a = new Address("서울시", "관악구", "070890");
            ProductOrder o = new ProductOrder("테스트", a, null);
            em.persist(o);
            //이렇게 persist 했을 때, Address 는 ProductOrder의 필드로 생성된다.
            //즉 별도의 엔티티가 아닌 필드를 나눠서 구성한다는 것.

            ProductOrder findOrder = em.find(ProductOrder.class, 1L);
            System.out.println(findOrder.toString());
            System.out.println(findOrder.getAddress().toString());
            //Address 에 toString이 되어있지 않으면 메모리주소만 나옴.

            System.out.println("================================= before commit =================================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            EMF.close();
        }


    }

}
