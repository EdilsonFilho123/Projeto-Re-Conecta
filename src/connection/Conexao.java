package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConnection(){    
       
        String driver = "com.mysql.cj.jdbc.Driver"; 
        String usuario = "root";
        String senha = "";
        
        String hostname = "localhost";
        String porta = "3306";
        String banco = "reconecta";
        String fuso = "useTimezone=true&serverTimezone=UTC";
        String url = "jdbc:mysql://" + hostname + ":" + porta + "/" + banco + "?" + fuso;
        
        try{
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        } 
        catch(SQLException | ClassNotFoundException ex) {
            throw new RuntimeException("Erro de conexão", ex);
        }
    }
}
