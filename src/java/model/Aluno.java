
package model;

import java.util.ArrayList;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
public class Aluno {
    @Id
    @GeneratedValue
    private int mat;
    
    @NotNull
    private String nome;
    private double av1;
    private double av2;
    
//Constructor
    public Aluno (){
        
    }

    public Aluno(int mat, String Nome) {
        this.mat = mat;
        this.nome = Nome;
    }

    public Aluno(int mat, String Nome, double av1, double av2) {
        this.mat = mat;
        this.nome = Nome;
        this.av1 = av1;
        this.av2 = av2;
    }
        
    
//Getters & Setters
    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAv1() {
        return av1;
    }

    public void setAv1(double av1) {
        this.av1 = av1;
    }

    public double getAv2() {
        return av2;
    }

    public void setAv2(double av2) {
        this.av2 = av2;
    }

}
