package DAO;

import ConnectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ConnectionFactory.ConnectionFactory;

public class AlunoDAO {
    public void cadastrarAluno(String nome){
        try{
            Connection conexao = ConnectionFactory.createConnection();
            
            String sql = "INSERT INTO sistemaaluno.aluno (nome_aluno) VALUES (?);";
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1,nome);
            comando.execute();
            comando.close();
            conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
    
    public ArrayList listarAluno(){
        ArrayList<Model.Aluno> Aluno = new ArrayList();
        try{
           Connection conexao = ConnectionFactory.createConnection();
           String sql = "SELECT * FROM sistemaaluno.aluno;";
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                Model.Aluno aluno_banco = new Model.Aluno();
                aluno_banco.setMat(resultado.getInt("matricula_aluno"));
                aluno_banco.setNome(resultado.getString("nome_aluno"));
                aluno_banco.setAv1(resultado.getDouble("av1_aluno"));
                aluno_banco.setAv2(resultado.getDouble("av2_aluno"));
                Aluno.add(aluno_banco);
            }
          comando.close();
          conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Aluno;
    }
    
    public void updateAluno(int mat,double av1,double av2){
        try{
            Connection conexao = ConnectionFactory.createConnection();
            
            String sql = "UPDATE sistemaaluno.aluno "
                    + "SET av1_aluno = "+av1+",av2_aluno = "+av2+" "
                    + "WHERE matricula_aluno = "+mat+";";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateAluno(int mat,String nome){
        try{
            Connection conexao = ConnectionFactory.createConnection();
            
            String sql = "UPDATE sistemaaluno.aluno "
                    + "SET nome_aluno = ?  "
                    + "WHERE matricula_aluno = ?;";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, nome);
            comando.setInt(2, mat);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
    public void updateAluno(int mat,String nome,double av1,double av2){
        try{
            Connection conexao = ConnectionFactory.createConnection();
            
            String sql = "UPDATE sistemaaluno.aluno SET av1_aluno = ?,av2_aluno = ?,nome_aluno = ? "
                    + "WHERE matricula_aluno = ?;";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setDouble(1, av1);
            comando.setDouble(2, av2);
            comando.setString(3, nome);
            comando.setInt(4, mat);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void deletarAluno(int mat){
        try{
            Connection conexao = ConnectionFactory.createConnection();
            
            String sql = "DELETE FROM sistemaaluno.aluno WHERE sistemaaluno.Aluno.matricula_aluno ="+mat+";";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.execute();
            conexao.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /*public static void main(String[] args) {
        AlunoDAO dao = new AlunoDAO();
        ArrayList<Model.Aluno> alunos;
        
        dao.updateAluno(13, 8, 9);
        alunos = dao.listarAluno();
    
        for(Model.Aluno lista : alunos){
            System.out.println("Nome: "+lista.getNome());
            System.out.println("Matricula: "+lista.getMat());
            System.out.println("AV1: "+lista.getAv1());
            System.out.println("AV2: "+lista.getAv2());
        }
        
    }*/
    
}
