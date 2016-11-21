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
import java.util.ArrayList;
import java.util.HashMap;

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
    
    public ArrayList<Item> selectByNotaFiscalCompra(long notaFiscal)
    {
        ArrayList<Item> itens = new ArrayList<Item>();
        
        String sql = "select * from itemCompra where notaFiscal = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setLong(1, notaFiscal);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                itens.add(new ItemDAO().selectByCodigo(resultSet.getInt(1)));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return itens;
    }
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
}
