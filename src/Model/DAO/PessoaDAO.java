/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import Model.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rafael
 */
public class PessoaDAO
{
    private Connection connection;
    
    public PessoaDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Pessoa pessoa)
    {
        String sql = "insert into pessoa(cpf, nome, sexo, dataNasc, email, telefone) values(?, ?, ?, ?, ?, ?);";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, pessoa.getCpf());
            preparedStatement.setString(2, pessoa.getNome());
            preparedStatement.setString(3, pessoa.getSexo());
            preparedStatement.setDate(4, new Date(pessoa.getDataNasc().getTime()));
            preparedStatement.setString(5, pessoa.getEmail());
            preparedStatement.setString(6, pessoa.getTelefone());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new EnderecoPessoaDAO().create(pessoa);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
        
    public void update()
    {
        
    }
    
    public void delete(String cpf)
    {
        String sql = "delete from pessoa where cpf = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            preparedStatement.executeQuery();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
