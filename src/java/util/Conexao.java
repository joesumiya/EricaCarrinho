/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joe Sumiya
 */
public class Conexao {
    
    public Connection conectar() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        // Cria uma nova conexão.
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/CarrinhoDeCompra", "postgres", "postgre");
        return conexao;
    }
}
