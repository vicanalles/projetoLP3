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
    
    Connection connection;
    
    public ItemDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Item item)
    {
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
    
    public Item selectByCodigo(int codigo)
    {
        Item item = new Item();
        
        String sql = "select (codigo, nome, descricao, quantidade, valorCompra) from item where codigo = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                item.setCodigo(resultSet.getInt(1));
                item.setNome(resultSet.getString(2));
                item.setDescricao(resultSet.getString(3));
                item.setQuantidade(resultSet.getFloat(4));
                item.setValorCompra(resultSet.getFloat(5));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return item;
    }
    
    public void update()
    {
        
    }
    
    public void delete(int codigo)
    {
        String sql = "delete from item where codigo = ?";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigo);
            
            preparedStatement.execute();
            preparedStatement.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int getNextID()
    {
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
        }
        
        return 0;
    }
}
