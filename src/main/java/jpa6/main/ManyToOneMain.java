package jpa6.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jpa0.Emf.EMF;
import jpa6.entity.MyBestShare;
import jpa6.entity.MyShare;
import jpa6.entity.Review;
import jpa6.entity.Sight;

import java.util.List;

public class ManyToOneMain {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            //일단 저장하고 시작
//            Sight s = new Sight("개드립");
//            em.persist(s);

//            Sight s = em.find(Sight.class, 1L);
//            Review r = new Review(s, "재밌어용");
//            em.persist(r);


            //JPQL 사용. 1: 변수에 id 사용
//            Query query = em.createQuery(
//                "select r from Review r where r.sight.id = :sightId order by r.id desc"
//            );
//            query.setParameter("sightId", 1L);

            //JPQL 사용. 2: 변수에 객체
            Sight s = em.find(Sight.class, 1L);
            Query query = em.createQuery(
                    "select r from Review r where r.sight = :sight order by r.id desc"
            );
            query.setParameter("sight", s);

            List<Review> results = query.getResultList();
            System.out.println(results.toString());


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
