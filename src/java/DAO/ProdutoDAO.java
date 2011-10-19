/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;
import util.Conexao;

/**
 *
 * @author Joe Sumiya
 */
public class ProdutoDAO {
    private Connection con;
    
    public ProdutoDAO() throws ClassNotFoundException, SQLException{
        Conexao conn = new Conexao();
        this.con = conn.conectar();
    }
    
    
    public void inserir(Produto produto) throws SQLException{
        PreparedStatement stmt = this.con.prepareStatement("INSERT INTO produto (nome, precounitario) values (?,?)");
        stmt.setString(1,produto.getNome());
        stmt.setDouble(2, produto.getPrecoUnitario());
        stmt.executeUpdate();
    }
    
    public void alterar (Produto produto) throws SQLException{
        PreparedStatement stmt = this.con.prepareStatement("Update produto set nome = ?, precounitario = ? where id = ?");
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPrecoUnitario());
        stmt.setInt(3, produto.getCodigo());
        stmt.executeUpdate();
    }
    
    public void excluir(Produto produto) throws SQLException {
        PreparedStatement stmt = this.con.prepareStatement("Delete from produto where id = ?");
        stmt.setInt(1, produto.getCodigo());
        stmt.executeUpdate();
    }

    public Produto buscarPorID(Produto produto) throws SQLException{
        PreparedStatement stmt = this.con.prepareStatement("Select * from produto where id = ?");
        stmt.setInt(1, produto.getCodigo());
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
        produto.setCodigo(rs.getInt("id"));
        produto.setNome(rs.getString("nome"));
        produto.setPrecoUnitario(rs.getDouble("precounitario"));
        }
        return produto;
    }

    public ArrayList<Produto> buscarTodos() throws SQLException{
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        PreparedStatement stmt = this.con.prepareStatement("Select * from produto");
        ResultSet rs = stmt.executeQuery();        
        
        while(rs.next()) {
            Produto produto = new Produto();
            produto.setCodigo(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPrecoUnitario(rs.getDouble("precounitario"));
            
            produtos.add(produto);
        }
        
        
        return produtos;
                
    }
}
