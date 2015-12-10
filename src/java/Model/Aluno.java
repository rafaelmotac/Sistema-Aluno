
package Model;

import java.util.ArrayList;

public class Aluno {
    
    private int mat;
    private String nome;
    private double t1;
    private double av1;
    private double av2;
    private double av3;
    
//Constructor
    public Aluno (){
        
    }

    public Aluno(int mat, String Nome) {
        this.mat = mat;
        this.nome = Nome;
    }

    public Aluno(int mat, String Nome, double t1, double av1, double av2, double av3) {
        this.mat = mat;
        this.nome = Nome;
        this.t1 = t1;
        this.av1 = av1;
        this.av2 = av2;
        this.av3 = av3;
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

    public double getT1() {
        return t1;
    }

    public void setT1(double t1) {
        this.t1 = t1;
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

    public double getAv3() {
        return av3;
    }

    public void setAv3(double av3) {
        this.av3 = av3;
    }
}
