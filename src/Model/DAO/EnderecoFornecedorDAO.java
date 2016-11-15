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
public class EnderecoFornecedorDAO
{
    private Connection connection;
    
    public EnderecoFornecedorDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Fornecedor fornecedor)
    {
        String sql = "insert into enderecoFornecedor(cnpjFornecedor, cep, rua, numero, bairro, cidade, estado, complemento) values('?', '?', '?', ?, '?', '?', '?', '?');";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getCep());
            preparedStatement.setString(3, fornecedor.getRua());
            preparedStatement.setInt(4, fornecedor.getNumero());
            preparedStatement.setString(5, fornecedor.getBairro());
            preparedStatement.setString(6, fornecedor.getCidade());
            preparedStatement.setString(5, fornecedor.getEstado());
            preparedStatement.setString(6, fornecedor.getComplemento());
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void selectByCnpjFornecedor(String cnpj)
    {
        
    }
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
}
