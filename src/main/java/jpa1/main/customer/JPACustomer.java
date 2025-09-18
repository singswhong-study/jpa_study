package jpa1.main.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Customer;

public class JPACustomer {
    public static void main(String[] args) {

        //데이터를 영속화 하기 위해선 entitymanager 가 필요.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study"); // persistence xml 에 설정했던 name;
        EntityManager em = emf.createEntityManager();

        //트랜잭션 단위로 진행된다는것을 잊지 말아야 한다. => 롤백 하거나 커밋을 해줘야한다.
        EntityTransaction tx = em.getTransaction();

        //여기서부터 데이터를 넣고 쓰고가 가능.
        tx.begin();
        
        //데이터 다루는 시점
        try {

            //데이터 저장
//            em.persist(Customer.sample());


            //조회
            Customer customer = em.find(Customer.class, "TEST");    //(클래스, id), * entity의 default 생성자가 없다면 오류 발생. 커스텀 생성자를 만들었으므로 추가해야함.

//            System.out.println(customer.toString());
            
            //수정. tx begin/commit 사이에서 객체의 값을 바꿈
            //조회해서 관리되어지고 있는 entity에서 값이 바뀌었으므로 tx commit 시 업데이트.
//            customer.setName("SWHONG");

            //삭제. 수정과 마찬가지로 조회후 관리 되어지고있는 entity 가 제거됨.
//            em.remove(customer);

            tx.commit();

        } catch (Exception e){
            tx.rollback();  //에러시 롤백
        } finally {
            //리소스 반납 및 종료. em,emf 닫기
            em.close();
            emf.close();
        }

    }
}
