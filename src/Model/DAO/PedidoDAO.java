/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Log;
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
            pedido.setLog(new Log(pedido.getLog().getTipoPedido()));            
            
            new LogDAO().create(pedido.getNumero(), pedido.getLog());
            new ProdutoPedidoDAO().create(pedido);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Pedido> selectAll()
    {
        String sql = "select numero, valorPedido, pagamento, cpfCliente, cpfFuncionario from pedido;";
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();                        
            
            while(resultSet.next())
            {
                Pedido pedido = new Pedido();

                pedido.setNumero(resultSet.getInt(1));
                pedido.setValorPedido(resultSet.getFloat(2));
                pedido.setPagamento(resultSet.getString(3));
                pedido.setCliente(new ClienteDAO().selectOneByCpf(resultSet.getString(4)));
                pedido.setFuncionario(new FuncionarioDAO().selectOneByCpf(resultSet.getString(5)));
                pedido.setProdutos(new ProdutoPedidoDAO().selectByNumeroPedido(resultSet.getInt(1)));
                pedido.setLog((new LogDAO().selectByNumeroPedido(resultSet.getInt(1))));
                
                pedidos.add(pedido);
            }
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
        
        return pedidos;
    }
    
    public void update(Pedido pedido)
    {
        String sql = "update pedido set valorPedido = ?, pagamento = ?, cpfCliente = ?, cpfFuncionario = ? where numero = ?;";
        
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setFloat(1, pedido.getValorPedido());
            preparedStatement.setString(2, pedido.getPagamento());
            preparedStatement.setString(3, pedido.getCliente().getCpf());
            preparedStatement.setString(4, pedido.getFuncionario().getCpf());
            preparedStatement.setInt(5, pedido.getNumero());
            
            preparedStatement.execute();
            preparedStatement.close();                        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int numeroPedido)
    {
        String sql = "delete from pedido where numero = ?;";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, numeroPedido);
            
            preparedStatement.execute();
            preparedStatement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public ArrayList<Pedido> selectByCpfCliente(String cpfCliente) {
        
        String sql = "select numero, valorPedido, pagamento, cpfCliente, cpfFuncionario from pedido where cpfCliente like ?;";
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpfCliente + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();                        
            
            while(resultSet.next())
            {
                Pedido pedido = new Pedido();

                pedido.setNumero(resultSet.getInt(1));
                pedido.setValorPedido(resultSet.getFloat(2));
                pedido.setPagamento(resultSet.getString(3));
                pedido.setCliente(new ClienteDAO().selectOneByCpf(resultSet.getString(4)));
                pedido.setFuncionario(new FuncionarioDAO().selectOneByCpf(resultSet.getString(5)));
                pedido.setProdutos(new ProdutoPedidoDAO().selectByNumeroPedido(resultSet.getInt(1)));
                pedido.setLog((new LogDAO().selectByNumeroPedido(resultSet.getInt(1))));
                
                pedidos.add(pedido);
            }
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
        
        return pedidos;
    }
}
