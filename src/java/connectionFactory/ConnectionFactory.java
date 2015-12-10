package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection createConnection() {
        String stringDeConexao = "jdbc:postgresql://localhost:5432/sistemaaluno";
        String usuario = "postgres";
        String senha = "123456";

        Connection conexao = null;

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }finally{
            return conexao;
        }

        
    }

}
