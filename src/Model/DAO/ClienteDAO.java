/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Rafael
 */
public class ClienteDAO
{
    private Connection connection;
    
    public ClienteDAO()
    {
        connection = new ConnectionFactory().getConnection();
    }
    
    public void create(Cliente cliente)
    {
        new PessoaDAO().create(cliente);
        
        String sql = "insert into cliente(cpf, produtoFavorito) values('?', '?');";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cliente.getCpf());
            preparedStatement.setString(2, cliente.getProdutoFavorito());
            
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
