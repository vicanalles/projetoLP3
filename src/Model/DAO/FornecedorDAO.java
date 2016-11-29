/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        String sql = "insert into fornecedor(cnpj, nome, nomeFantasia, telefone, cep, rua, numero, bairro, cidade, estado, complemento, anotacoes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getNomeFantasia());
            preparedStatement.setString(4, fornecedor.getTelefone());
            preparedStatement.setString(5, fornecedor.getCep());
            preparedStatement.setString(6, fornecedor.getRua());
            preparedStatement.setInt(7, fornecedor.getNumero());
            preparedStatement.setString(8, fornecedor.getBairro());
            preparedStatement.setString(9, fornecedor.getCidade());
            preparedStatement.setString(10, fornecedor.getEstado());
            preparedStatement.setString(11, fornecedor.getComplemento());
            preparedStatement.setString(12, fornecedor.getAnotacoes());
            
            preparedStatement.execute();
            preparedStatement.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Fornecedor selectOneByCnpj(String cnpj)
    {
        String sql = "select cnpj, nome, nomeFantasia, telefone, cep, rua, numero, bairro, cidade, estado, complemento, anotacoes from fornecedor where cnpj = ?;";
        Fornecedor fornecedor = new Fornecedor();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cnpj);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next())
            {
                fornecedor.setCnpj(resultSet.getString(1));
                fornecedor.setNome(resultSet.getString(2));
                fornecedor.setNomeFantasia(resultSet.getString(3));
                fornecedor.setTelefone(resultSet.getString(4));
                fornecedor.setCep(resultSet.getString(5));
                fornecedor.setRua(resultSet.getString(6));
                fornecedor.setNumero(resultSet.getInt(7));
                fornecedor.setBairro(resultSet.getString(8));
                fornecedor.setCidade(resultSet.getString(9));
                fornecedor.setEstado(resultSet.getString(10));
                fornecedor.setComplemento(resultSet.getString(11));
                fornecedor.setAnotacoes(resultSet.getString(12));
            }
            
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return fornecedor;
    }
    
    public ArrayList<Fornecedor> selectByCnpj(String cnpj)
    {
        String sql = "select cnpj, nome, nomeFantasia, telefone, cep, rua, numero, bairro, cidade, estado, complemento, anotacoes from fornecedor where cnpj like ?;";
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cnpj + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCnpj(resultSet.getString(1));
                fornecedor.setNome(resultSet.getString(2));
                fornecedor.setNomeFantasia(resultSet.getString(3));
                fornecedor.setTelefone(resultSet.getString(4));
                fornecedor.setCep(resultSet.getString(5));
                fornecedor.setRua(resultSet.getString(6));
                fornecedor.setNumero(resultSet.getInt(7));
                fornecedor.setBairro(resultSet.getString(8));
                fornecedor.setCidade(resultSet.getString(9));
                fornecedor.setEstado(resultSet.getString(10));
                fornecedor.setComplemento(resultSet.getString(11));
                fornecedor.setAnotacoes(resultSet.getString(12));
                
                fornecedores.add(fornecedor);
            }
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return fornecedores;
    }
    
    public ArrayList<Fornecedor> selectByFantasyName(String nomeFantasia)
    {
        String sql = "select cnpj, nome, nomeFantasia, telefone, cep, rua, numero, bairro, cidade, estado, complemento, anotacoes from fornecedor where nomeFantasia like ?;";
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,"%" + nomeFantasia + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Fornecedor fornecedor = new Fornecedor();

                fornecedor.setCnpj(resultSet.getString(1));                
                fornecedor.setNome(resultSet.getString(2));
                fornecedor.setNomeFantasia(resultSet.getString(3));
                fornecedor.setTelefone(resultSet.getString(4));
                fornecedor.setCep(resultSet.getString(5));
                fornecedor.setRua(resultSet.getString(6));
                fornecedor.setNumero(resultSet.getInt(7));
                fornecedor.setBairro(resultSet.getString(8));
                fornecedor.setCidade(resultSet.getString(9));
                fornecedor.setEstado(resultSet.getString(10));
                fornecedor.setComplemento(resultSet.getString(11));
                fornecedor.setAnotacoes(resultSet.getString(12));

                fornecedores.add(fornecedor);
            }            
            preparedStatement.close();
            return fornecedores;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }                
    }
    
    public void update(Fornecedor fornecedor, String cnpjAntigo)
    {
        String sql = "update fornecedor set cnpj = ?, nome = ?, nomeFantasia = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ?, anotacoes = ? where cnpj = ?;";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getNomeFantasia());
            preparedStatement.setString(4, fornecedor.getCep());
            preparedStatement.setString(5, fornecedor.getRua());
            preparedStatement.setInt(6, fornecedor.getNumero());
            preparedStatement.setString(7, fornecedor.getBairro());
            preparedStatement.setString(8, fornecedor.getCidade());
            preparedStatement.setString(9, fornecedor.getEstado());
            preparedStatement.setString(10, fornecedor.getComplemento());
            preparedStatement.setString(11, fornecedor.getAnotacoes());
            preparedStatement.setString(12, cnpjAntigo);
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete(String cnpjFornecedor)
    {
        String sql = "delete from fornecedor where cnpj = ?;";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cnpjFornecedor);
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
