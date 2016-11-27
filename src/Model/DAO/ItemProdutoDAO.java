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
public class ItemProdutoDAO
{
    Connection connection;
    
    public ItemProdutoDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(int codigoProduto, ArrayList<Item> itens)
    {
        String sql = "insert into itemproduto (codigoProduto, codigoItem, quantidade, valorCompra) values (?, ?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigoProduto);
            
            for(Item item : itens)
            {
                preparedStatement.setInt(2, item.getCodigo());
                preparedStatement.setFloat(3, item.getQuantidade());
                preparedStatement.setFloat(4, item.getValorCompra());
                preparedStatement.execute();                
            }                               
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Item selectOneByCodigo(int codigo)
    {
        String sql = "select * from itemProduto where codigo = ?;";        
        
        Item item = new Item();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigo);
            
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
                item.setCodigo(resultSet.getInt(1));
                item.setQuantidade(resultSet.getFloat(2));
                item.setValorCompra(resultSet.getFloat(3));
            }
            
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return item;
    }
    
    public ArrayList<Item> selectByCodigoProduto(int codigoProduto)
    {
        String sql = "select * from itemproduto where codigoProduto = ?;";        
        
        ArrayList<Item> itens = new ArrayList<Item>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, codigoProduto);
            
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Item item = new ItemDAO().selectByCodigo(resultSet.getInt(2));
                item.setQuantidade(resultSet.getFloat(3));
                item.setValorCompra(resultSet.getFloat(4));
                itens.add(item);
            }    
            
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return itens;
    }
    
    public void update(Produto produto)
    {
        String sql = "update itemproduto set codigoItem = ?, quantidade = ?, valorCompra = ? where codigoProduto = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);                        
            
            for(Item item : produto.getItens())
            {
                preparedStatement.setInt(1, item.getCodigo());
                preparedStatement.setFloat(2, item.getQuantidade());
                preparedStatement.setFloat(3, item.getValorCompra());
                preparedStatement.setInt(4, produto.getCodigo());
                System.out.println(preparedStatement);
                preparedStatement.execute();
            }
            
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }                
    }   
    
    
    public void delete(int codigoProduto)
    {
        String sql = "delete from itemproduto where codigoProduto = ?";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigoProduto);
            
            preparedStatement.execute();
            preparedStatement.close();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
