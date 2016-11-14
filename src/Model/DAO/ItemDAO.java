/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rafael
 */
public class ItemDAO
{
    public void create(Item item)
    {
        Connection connection = new ConnectionFactory().getConnection();
    
        String sql = "insert into item(codigo, nome, descricao, quantidade, valorCompra) values (?, ?, ?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, item.getCodigo());
            preparedStatement.setString(2, item.getNome());
            preparedStatement.setString(3, item.getDescricao());
            preparedStatement.setFloat(4, item.getQuantidade());
            preparedStatement.setFloat(5, item.getValorCompra());
            
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
    
        String sql = "SELECT auto_increment FROM information_schema.tables WHERE TABLE_NAME = 'item';";
        
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
