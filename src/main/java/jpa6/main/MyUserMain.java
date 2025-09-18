package jpa6.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa6.entity.MyUser;
import jpa6.entity.MyUserCard;

public class MyUserMain {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            //참조키 값의 단방향 매핑.

//            MyUser u = new MyUser("swhong@email.com", "홍");
//            em.persist(u);
//            일단 하나 인서트 한 상태에서 시작

//            MyUser u = em.find(MyUser.class, "swhong@email.com");
//            MyUserCard c = new MyUserCard("123-456-789", u);
//            em.persist(c);

//            MyUserCard c1 = new MyUserCard("345-456-789", null);
//            em.persist(c1);

            MyUserCard c2 = em.find(MyUserCard.class, "123-456-789");
            System.out.println(c2.toString());
            //One to One 관계는 기본 FetchType 이 Eager 라서 join 바로 조회된다.
            //One to One 의 fetch 옵션을 LAZY로 바꾸면 지연로딩으로 바뀐다.


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
