package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sistema-aluno");
    
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    
    }
    
    public EntityManagerFactory getEntityManagerFactory(){
         return entityManagerFactory;
    }
       
}
