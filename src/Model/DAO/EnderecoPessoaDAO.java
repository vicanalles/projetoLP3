/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Rafael
 */
public class EnderecoPessoaDAO
{
    private Connection connection;
    
    public EnderecoPessoaDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Pessoa pessoa)
    {
        String sql = "insert into enderecoPessoa(cpfPessoa, cep, rua, numero, bairro, cidade, estado, complemento) values(?, ?, ?, ?, ?, ?, ?, ?);";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, pessoa.getCpf());
            preparedStatement.setString(2, pessoa.getCep());
            preparedStatement.setString(3, pessoa.getRua());
            preparedStatement.setInt(4, pessoa.getNumero());
            preparedStatement.setString(5, pessoa.getBairro());
            preparedStatement.setString(6, pessoa.getCidade());
            preparedStatement.setString(7, pessoa.getEstado());
            preparedStatement.setString(8, pessoa.getComplemento());
            
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
    
    public void update(Pessoa pessoa)
    {
        String sql = "update enderecoPessoa set cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ? where cpfPessoa = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, pessoa.getCep());
            preparedStatement.setString(2, pessoa.getRua());
            preparedStatement.setInt(3, pessoa.getNumero());
            preparedStatement.setString(4, pessoa.getBairro());
            preparedStatement.setString(5, pessoa.getCidade());
            preparedStatement.setString(6, pessoa.getEstado());
            preparedStatement.setString(7, pessoa.getComplemento());
            preparedStatement.setString(8, pessoa.getCpf());
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete(String cpf)
    {
        String sql = "delete from enderecoPessoa where cpfPessoa = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
