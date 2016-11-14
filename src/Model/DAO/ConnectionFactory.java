/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rafael
 */
public class ConnectionFactory
{
    private static ConnectionFactory instance = null;
    
    private ConnectionFactory()
    {
        
    }
    
    public static ConnectionFactory getInstance()
    {
        if(instance == null)
            instance = new ConnectionFactory();
        
        return instance;
    }
    
    public Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/projetolp3", "root", "0000");
            //return DriverManager.getConnection("jdbc:mysql://localhost/projetolp3", "root", "root");
        }
        catch(SQLException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}

/*
public class ConnectionFactory
{
    public Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost/projetolp3", "root", "0000");
            //return DriverManager.getConnection("jdbc:mysql://localhost/projetolp3", "root", "root");
        }
        catch(SQLException exception)
        {
            throw new RuntimeException(exception);
        }
    }
}
*/
