/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Item;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ProdutoDAO
{
    Connection connection;
    
    public ProdutoDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Produto produto)
    {
        String sql = "insert into produto(codigo, nome, valor) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, produto.getCodigo());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setFloat(3, produto.getValor());                        
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new ItemProdutoDAO().create(produto);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void read()
    {
        
    }
    
    public void update(Produto produto)
    {
        String sql = "update produto set nome = ?, valor = ? where codigo = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setFloat(2, produto.getValor());
            preparedStatement.setInt(3, produto.getCodigo());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new ItemProdutoDAO().create(produto);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete(int codigo)
    {
        String sql = "delete from produto where codigo = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigo);
            
            preparedStatement.execute();
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public int getNextID()
    {
        String sql = "SELECT auto_increment FROM information_schema.tables WHERE TABLE_NAME = 'produto';";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            
            return resultSet.getInt(1);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<Produto> selectByName(String nome)
    {
        String sql = "select codigo, nome, valor from produto where nome like ?;";
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nome + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();                        
            
            while(resultSet.next())
            {
                Produto produto = new Produto();

                produto.setCodigo(resultSet.getInt(1));
                produto.setNome(resultSet.getString(2));
                produto.setValor(resultSet.getFloat(3)); 
                produto.setItens(new ItemProdutoDAO().selectByCodigoProduto(produto.getCodigo()));

                produtos.add(produto);
            }
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
        return produtos;
    }
    
    public Produto selectByCodigo(int codigo)
    {
        String sql = "select codigo, nome, valor from produto where codigo = ?;";        
        Produto produto = new Produto();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultSet = preparedStatement.executeQuery();                        
            
            if(resultSet.next())
            {                
                produto.setCodigo(resultSet.getInt(1));
                produto.setNome(resultSet.getString(2));
                produto.setValor(resultSet.getFloat(3));                               
            }
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
        return produto;
    }
}
