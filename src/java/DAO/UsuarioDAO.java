package DAO;

import Model.Usuario;
import ConnectionFactory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuarioDAO {


public static Usuario getUsuario(String login, String senha){
  
    Usuario user = null;
    try{
        Connection conexao = ConnectionFactory.createConnection();
        String sql = "select login,senha from sistemaaluno.Usuario WHERE (login = ? AND senha = ?);";
        
        PreparedStatement comando = conexao.prepareStatement(sql);
        comando.setString(1, login);
        comando.setString(2, senha);
        ResultSet resultado = comando.executeQuery();
        if(resultado.next()){
            user = new Usuario();
            user.setLogin(resultado.getString("login"));
            user.setSenha(resultado.getString("senha"));    
            
        }
        
        resultado.close();
        comando.close();
        conexao.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    
    return user;
}
/*
        public static void main(String args[]){
            UsuarioDAO u = new UsuarioDAO();
            boolean a;
            a = u.getUsuario("admin","senha123456");
            System.out.println(a);
            boolean b = u.getUsuario("lala","lili");
            System.out.println(b);
        }*/
}
