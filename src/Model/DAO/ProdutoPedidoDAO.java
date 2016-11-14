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
    
    public void create(Pedido pedido, Produto produto)
    {
        String sql = "insert into produtoPedido(numeroPedido, codigoProduto, quantidadeProduto) values (?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, pedido.getNumero());
            preparedStatement.setInt(2, produto.getCodigo());
            preparedStatement.setFloat(3, produto.getQuantidade());
            
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
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
}
