package jpa4.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa4.entity.*;

public class main {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {


            //본 엔티티에 secondaryTables + 각 객체의  @Column(table = "assist", name="name") 필드명에 테이블 명시
            Writer w = new Writer("HONG", 1);
            Assist a = new Assist("CHOI", "F");
            Topic t = new Topic("주제", w, a);
            em.persist(t);


            //본 엔티티에 secondaryTables + attributeOverrides
            Writer2 w2 = new Writer2("HONG", 1);
            Assist2 a2 = new Assist2("CHOI", "F");
            Topic2 t2 = new Topic2("주제", w2, a2);
            em.persist(t2);

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
