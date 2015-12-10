/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.JPAUtil;
import model.Aluno;
import model.Usuario;

/**
 *
 * @author rafael
 */
public class TesteJPA {
    
    public static void main (String args[]){
        model.Aluno aluno = new Aluno();
        aluno.setMat(3);
        
        
        
        
         EntityManager manager = new JPAUtil().getEntityManager();
         EntityManagerFactory emf = new JPAUtil().getEntityManagerFactory();
         
         
         manager.getTransaction().begin();
         
         manager.merge(aluno);
         
         manager.getTransaction().commit();
         
         manager.close();
         
         emf.close();
         
         
         
    }
    
}
