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
import java.sql.ResultSet;

/**
 *
 * @author Rafael
 */
public class LogDAO
{
    Connection connection;
    
    public LogDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(int numeroPedido, Log log)
    {
        String sql = "insert into log(numeroPedido, tipoPedido, horaAberturaPedido) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, numeroPedido);
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
    
    public Log selectByNumeroPedido(int numeroPedido)
    {
        String sql = "select * from log where numeroPedido = ?";
        Log log = null;
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, numeroPedido);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            
            log = new Log(resultSet.getInt(2));
            
            log.setHoraAberturaPedido(resultSet.getDate(3));
            log.setHoraInicioProducao(resultSet.getDate(4));
            log.setHoraTerminoProducao(resultSet.getDate(5));
            log.setHoraSaidaEntrega(resultSet.getDate(6));
            log.setHoraRetornoEntrega(resultSet.getDate(7));
            log.setHoraFinalizacaoPedido(resultSet.getDate(8));
            
            preparedStatement.close();
            
            return log;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
}
