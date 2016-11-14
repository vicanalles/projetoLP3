/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Log;
import Model.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Rafael
 */
public class LogDAO
{
    public void create(Pedido pedido, Log log)
    {
        Connection connection = new ConnectionFactory().getConnection();
        
        String sql = "insert into log(numeroPedido, tipoPedido, horaAberturaPedido) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, pedido.getNumero());
            preparedStatement.setInt(2, log.getTipoPedido());
            preparedStatement.setDate(3, new Date(log.getHorarios()[0].getTime()));
            
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
