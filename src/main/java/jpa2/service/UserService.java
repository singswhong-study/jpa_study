package jpa2.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa2.Emf.EMF;
import jpa2.entity.Member;

public class UserService {

    public void saveUser(Member member){

        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            em.persist(member);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }

    public void updateUser(Long id, String name){

        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Member u = em.find(Member.class, id);
            u.setName(name);

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

    }
    public Member getUser(Long id){

        EntityManager em = EMF.createManager();
        Member u = null;
        try {

            u = em.find(Member.class, id);

            if(u == null){
                throw new Exception("유저 없음");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return u;
    }

    public void removeUser(Long id){
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Member u = em.find(Member.class, id);
            if(u != null){
                em.remove(u);
            }
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

}
