package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        catch(ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de conexão", ex);
        }
    }
    
    public static void main(String args[]){
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("sua mae");
    }
}
