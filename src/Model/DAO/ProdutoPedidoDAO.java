/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Pedido;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class ProdutoPedidoDAO
{
    Connection connection;
    
    public ProdutoPedidoDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Pedido pedido)
    {
        String sql = "insert into produtoPedido(numeroPedido, codigoProduto, quantidadeProduto) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, pedido.getNumero());
            
            for (Produto produto : pedido.getProdutos())
            {
                preparedStatement.setInt(2, produto.getCodigo());
                preparedStatement.setFloat(3, produto.getQuantidade());
            
                preparedStatement.execute();
            }
            
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Produto> selectByNumeroPedido(int numeroPedido)
    {
        String sql = "select codigoProduto, quantidadeProduto from produtoPedido where numeroPedido = ?;";
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, numeroPedido);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next())
            {
                Produto produto = new ProdutoDAO().selectByCodigo(resultSet.getInt(1));
                
                produto.setQuantidade(resultSet.getInt(2));
                
                produtos.add(produto);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return produtos;
    }
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
}
