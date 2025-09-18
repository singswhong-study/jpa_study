package jpa0.Emf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {
    private static EntityManagerFactory emf;

    public static void init(){
        emf = Persistence.createEntityManagerFactory("jpa-study");
    }

    public static EntityManager createManager(){
        return emf.createEntityManager();
    }

    public static void close(){
        emf.close();
    }

}
