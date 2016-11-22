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
        
        
        String sql = "insert into fornecedor(cnpj, nome, nomeFantasia) values (?, ?, ?);";
    
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
            
            preparedStatement.setString(1, cnpj + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            Fornecedor fornecedor = new Fornecedor();
            
            if(resultSet.next())
            {
                

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
    
    public ArrayList<Fornecedor> selectByName(String nomeFantasia)
    {
        String sql = "select f.cnpj, f.nome, f.nomeFantasia, e.cep, e.rua, e.numero, e.bairro, e.cidade, e.estado, e.complemento from fornecedor f, enderecoFornecedor e where f.nomeFantasia like ? and f.cnpj = e.cnpjFornecedor;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,"%" + nomeFantasia + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
            
            while(resultSet.next())
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
                fornecedor.setComplemento(resultSet.getString(10));;

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
    
    public void update(Fornecedor fornecedor)
    {
        String sql = "update fornecedor set cnpj = ?, nome = ?, nomeFantasia = ? where cnpj = ?;";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, fornecedor.getCnpj());
            preparedStatement.setString(2, fornecedor.getNome());
            preparedStatement.setString(3, fornecedor.getNomeFantasia());
            preparedStatement.setString(4, fornecedor.getCnpj());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new EnderecoFornecedorDAO().update(fornecedor);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete()
    {
        
    }
}
