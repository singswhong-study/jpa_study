package jpa1.main.relation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpa1.entity.Major;
import jpa1.entity.Student;

public class JPARelation {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-study");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {

//            Major m = new Major("computer", "IT");
//            em.persist(m);
//
//            Student s = new Student("kim", "3");
//            s.setMajorId(m.getMajorId());
//            em.persist(s);
//            em.flush();
//            em.clear();
//
//            // student 검색
//            Student findStudent = em.find(Student.class, 1);
//            System.out.println(findStudent.toString());
//
//            Major findMajor = em.find(Major.class, findStudent.getMajorId());
//            System.out.println(findMajor.toString());
// 이렇게 하는 것은 테이블식의 외래키.

            Major m = new Major("Computer", "IT");
            em.persist(m);

            Student s = new Student("KIM", "3");
            s.setMajor(m);
            em.persist(s);

            em.flush();
            em.clear();

            Student findStudent = em.find(Student.class, 1);
//            System.out.println(findStudent.toString());
//            Student(studentId=1, name=KIM, grade=3, major=Major(majorId=1, name=Computer, category=IT))
// Major 객체가 존재한다.
            System.out.println(findStudent.getMajor().getName());
// FetchType.LAZY 일때 Student 만 조회한다. 그리고 Major 에 접근하는 시도를 할 때 Major 조회한다.
// FetchType.EAGER 일때 join으로 즉시 가져옴.


            tx.commit();

        } catch (Exception e ){
            tx.rollback();
        } finally {
            em.close();
            emf.close();
        }

    }
}
