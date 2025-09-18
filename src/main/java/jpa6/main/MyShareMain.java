package jpa6.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa6.entity.MyBestShare;
import jpa6.entity.MyShare;
import jpa6.entity.MyUserCard;

public class MyShareMain {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            //식별자 공유 1:1 단방향 연관 매핑
//            MyShare m = new MyShare("sw@email.com", "아이구");
//            em.persist(m);

            MyShare m1 = em.find(MyShare.class, "sw@email.com");
            MyBestShare b1 = new MyBestShare(m1, "타이틀요");
            em.persist(b1);



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
