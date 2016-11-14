/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Rafael
 */
public class FornecedorDAO
{
    public void create(Fornecedor fornecedor)
    {
        Connection connection = new ConnectionFactory().getConnection();
    
        String sql = "insert into fornecedor values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getNomeFantasia());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new EnderecoFornecedorDAO().create(fornecedor);
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
