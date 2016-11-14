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
public class ItemCompraDAO
{
    Connection connection;
    
    public ItemCompraDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(long notaFiscal, Item item)
    {
        String sql = "insert into itemCompra(notaFiscal, codigoItem) values (?, ?);";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setLong(1, notaFiscal);
            preparedStatement.setInt(2, item.getCodigo());
            
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
