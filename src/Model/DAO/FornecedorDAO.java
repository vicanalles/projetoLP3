/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Fornecedor;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rafael
 */
public class FornecedorDAO
{
    Connection connection;
    
    public FornecedorDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Fornecedor fornecedor)
    {
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
    
    public Fornecedor selectByCnpj(String cnpj)
    {
        String sql = "select f.cnpj, f.nome, f.nomeFantasia, e.cep, e.rua, e.numero, e.bairro, e.cidade, e.estado, e.complemento from fornecedor f inner join enderecoFornecedor e on f.cnpj = e.cnpjFornecedor where f.cnpj = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cnpj);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setCnpj(resultSet.getString(1));
                fornecedor.setNome(resultSet.getString(2));
                fornecedor.setNomeFantasia(resultSet.getString(3));
                fornecedor.setCep(resultSet.getString(4));
                fornecedor.setRua(resultSet.getString(5));
                fornecedor.setNumero(resultSet.getInt(6));
                fornecedor.setBairro(resultSet.getString(7));
                fornecedor.setCidade(resultSet.getString(8));
                fornecedor.setEstado(resultSet.getString(9));
                fornecedor.setComplemento(resultSet.getString(10));

                preparedStatement.close();

                return fornecedor;
            }
            
            return null;
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
