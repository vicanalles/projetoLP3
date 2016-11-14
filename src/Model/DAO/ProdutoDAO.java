/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rafael
 */
public class ProdutoDAO
{
    public void create(Produto produto)
    {
        Connection connection = new ConnectionFactory().getConnection();
    
        String sql = "insert into produto(codigo, nome, valor) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setFloat(3, produto.getValor());
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void read()
    {
        
    }
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
    
    public int getNextID()
    {
        Connection connection = new ConnectionFactory().getConnection();
    
        String sql = "SELECT auto_increment FROM information_schema.tables WHERE TABLE_NAME = 'produto';";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            
            return resultSet.getInt(1);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
