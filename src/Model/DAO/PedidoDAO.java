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

/**
 *
 * @author Rafael
 */
public class PedidoDAO
{
    Connection connection;
    
    public PedidoDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Pedido pedido)
    {
        String sql = "insert into pedido(numero, valorPedido, pagamento, cpfCliente, cpfFuncionario) values (?, ?, ?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, pedido.getNumero());
            preparedStatement.setFloat(2, pedido.getValorPedido());
            preparedStatement.setString(3, pedido.getPagamento());
            preparedStatement.setString(4, pedido.getCliente().getCpf());
            preparedStatement.setString(5, pedido.getFuncionario().getCpf());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            new LogDAO().create(pedido, pedido.getLog());
            
            for (Produto produto : pedido.getProdutos())
            {
                new ProdutoPedidoDAO().create(pedido, produto);
            }
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
    
    public int getNextID()
    {
        String sql = "SELECT auto_increment FROM information_schema.tables WHERE TABLE_NAME = 'pedido';";
        
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
}
