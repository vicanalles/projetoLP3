/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Rafael
 */
public class FuncionarioDAO
{
    public void create(Funcionario funcionario)
    {
        Connection connection = new ConnectionFactory().getConnection();
    
        new PessoaDAO().create(funcionario);
        
        String sql = "insert into funcionario(cpf, funcao, salario) values(?, ?, ?);";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, funcionario.getCpf());
            preparedStatement.setString(2, funcionario.getFuncao());
            preparedStatement.setFloat(3, funcionario.getSalario());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new EnderecoPessoaDAO().create(funcionario);
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
