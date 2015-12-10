/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Aluno;

/**
 *
 * @author rafael
 */
public class AlunoJPAController {
    EntityManager manager = new JPAUtil().getEntityManager();
    EntityManagerFactory emf = new JPAUtil().getEntityManagerFactory();
    
    public void cadastrarAluno(String nome){
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        manager.getTransaction().begin();
        manager.persist(aluno);
        manager.getTransaction().commit();
        manager.close();
        emf.close();
    }
    
    public void cadastrarNotas(int mat,double av1,double av2){
        manager.getTransaction().begin();
        Aluno aluno = manager.find(Aluno.class, mat);
        aluno.setAv1(av1);
        aluno.setAv2(av2);
        manager.getTransaction().commit();
        manager.close();
        emf.close();
        
    }
    
   
    
}
