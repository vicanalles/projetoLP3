/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rafael
 */
public class FuncionarioDAO
{
    Connection connection;
    
    public FuncionarioDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Funcionario funcionario)
    {
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
    
    public Funcionario selectByCpf(String cpf)
    {
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, f.funcao, f.salario from pessoa p, funcionario f where p.cpf = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                Funcionario funcionario = new Funcionario();

                funcionario.setCpf(resultSet.getString(1));
                funcionario.setNome(resultSet.getString(2));
                funcionario.setSexo(resultSet.getString(3));
                funcionario.setDataNasc(resultSet.getDate(4));
                funcionario.setEmail(resultSet.getString(5));
                funcionario.setTelefone(resultSet.getString(6));
                funcionario.setFuncao(resultSet.getString(7));
                funcionario.setSalario(resultSet.getFloat(8));

                preparedStatement.close();

                return funcionario;
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
