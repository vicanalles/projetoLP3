/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Rafael
 */
public class ItemProdutoDAO
{
    Connection connection;
    
    public ItemProdutoDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Item item)
    {
        String sql = "insert into itemProduto (codigoItem, quantidade, valorCompra) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, item.getCodigo());
            preparedStatement.setFloat(2, item.getQuantidade());
            preparedStatement.setFloat(3, item.getValorCompra());
            
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
}
