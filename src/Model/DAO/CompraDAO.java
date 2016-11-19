/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.Compra;
import Model.Item;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rafael
 */
public class CompraDAO
{
    Connection connection;
    
    public CompraDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Compra compra)
    {
        String sql = "insert into compra(notaFiscal, valorTotal, data, cpfFuncionario, cnpjFornecedor) values (?, ?, ?, ?, ?);";
    
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setLong(1, compra.getNotaFiscal());
            preparedStatement.setFloat(2, compra.getValorTotal());
            preparedStatement.setDate(3, new Date(compra.getData().getTime()));
            preparedStatement.setString(4, compra.getFuncionario().getCpf());
            preparedStatement.setString(5, compra.getFornecedor().getCnpj());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            for (Map.Entry<Integer, Item> item : compra.getItens().entrySet())
            {
                new ItemCompraDAO().create(compra.getNotaFiscal(), item.getValue());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public HashMap<Long, Compra> selectAll()
    {
        HashMap<Long, Compra> compras = new HashMap<Long, Compra>();
        
        String sql = "select (notaFiscal, valorTotal, data, cpfFuncionario, cnpjFornecedor) from compra;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Compra compra = new Compra();
                
                compra.setNotaFiscal(resultSet.getLong(1));
                compra.setValorTotal(resultSet.getFloat(2));
                compra.setData(resultSet.getDate(3));
                compra.setFuncionario(new FuncionarioDAO().selectByCpf(resultSet.getString(4)));
                compra.setFornecedor(new FornecedorDAO().selectByCnpj(resultSet.getString(5)));
                compra.setItens(new ItemCompraDAO().selectByNotaFiscalCompra(compra.getNotaFiscal()));
                
                compras.put(compra.getNotaFiscal(), compra);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return compras;
    }
    
    public void update()
    {
        
    }
    
    public void delete()
    {
        
    }
    
    public int getNextID()
    {
        String sql = "SELECT auto_increment FROM information_schema.tables WHERE TABLE_NAME = 'compra';";
        
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