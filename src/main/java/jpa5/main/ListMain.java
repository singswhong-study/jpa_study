package jpa5.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa5.entity.Question;

import java.util.List;

public class ListMain {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Question q = new Question("정답이뭘까유", List.of("보기1", "보기2"));
            em.persist(q);

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
