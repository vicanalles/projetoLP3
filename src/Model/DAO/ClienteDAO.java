/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rafael
 */
public class ClienteDAO
{
    private Connection connection;
    
    public ClienteDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
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
    
    public ArrayList<Cliente> selectByName(String nome)
    {
        String sql;
        if(nome.equals(""))
            sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, c.produtofavorito from pessoa p, cliente c where p.cpf in (select cpf from cliente);";
        else
            sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, c.produtofavorito from pessoa p, cliente c where p.nome like '%" + nome + "%' and p.cpf in (select cpf from cliente);";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            
            while(resultSet.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(resultSet.getString(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setSexo(resultSet.getString(3));
                cliente.setDataNasc(resultSet.getDate(4));
                cliente.setEmail(resultSet.getString(5));
                cliente.setTelefone(resultSet.getString(6));
                cliente.setProdutoFavorito(resultSet.getString(7));
                
                clientes.add(cliente);
            }
            return clientes;
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
