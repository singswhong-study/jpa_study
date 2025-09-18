package jpa5.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa5.entity.Doc;
import jpa5.entity.Question;

import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Doc c = new Doc("문서에요", "내용입니다", Map.of("키1", "밸류1", "키2", "밸류2"));
            em.persist(c);

            Doc findDoc = em.find(Doc.class, 1L);
            findDoc.getProps().put("키1", "밸류9"); //기존값 변경시 업데이트
            findDoc.getProps().remove("키2");
            //딜리트 우선, 업데이트, 혹시 추가되면 마지막에 인서트


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
