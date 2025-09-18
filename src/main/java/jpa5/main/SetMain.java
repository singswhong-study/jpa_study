package jpa5.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa0.Emf.EMF;
import jpa5.entity.Role;

public class SetMain {

    public static void main(String[] args) {

        EMF.init();
        EntityManager em = EMF.createManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Role r = new Role("관리자", java.util.Set.of("F1"));
            em.persist(r);

            Role findRole = em.find(Role.class, 1L);
            System.out.println(findRole.getPermissions());
            //Permission에 접근할때 select로 로드함. lazy loading

            findRole.getPermissions().add("F3");            // 추가
            findRole.getPermissions().remove("F1");      // 삭제
            //이런식으로 되면 삭제가 먼저 되고, add 한것이 추가됨
            //findRole.getPermissions().clear();    // delete 쿼리날라감.
            //findRole.remove() // 를 하게되면 하위 콜랙션까지 다 삭제함.

            findRole.setPemissions(java.util.Set.of("O1", "O2"));
            //전체 다 삭제하고 새로 insert

            //.clear()

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
