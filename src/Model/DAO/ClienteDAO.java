package Model.DAO;

import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
        
        String sql = "insert into cliente(cpf, produtoFavorito) values(?, ?);";
        
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
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, p.cep, p.rua, p.numero, p.bairro, p.cidade, p.estado, p.complemento, c.produtofavorito from pessoa p, cliente c where p.nome like ? and p.cpf = c.cpf;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nome + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(resultSet.getString(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setSexo(resultSet.getString(3));
                cliente.setDataNasc(resultSet.getDate(4));
                cliente.setEmail(resultSet.getString(5));
                cliente.setTelefone(resultSet.getString(6));
                
                cliente.setCep(resultSet.getString(7));
                cliente.setRua(resultSet.getString(8));
                cliente.setNumero(resultSet.getInt(9));
                cliente.setBairro(resultSet.getString(10));
                cliente.setCidade(resultSet.getString(11));
                cliente.setEstado(resultSet.getString(12));
                cliente.setComplemento(resultSet.getString(13));
                
                cliente.setProdutoFavorito(resultSet.getString(14));
                
                clientes.add(cliente);
            }
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public ArrayList<Cliente> selectByCpf(String cpf)
    {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, c.produtofavorito, e.cep, e.rua, e.numero, e.bairro, e.cidade, e.estado, e.complemento from pessoa p, cliente c, enderecoPessoa e where c.cpf like ? and p.cpf = c.cpf and p.cpf = e.cpfPessoa;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
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
                cliente.setCep(resultSet.getString(8));
                cliente.setRua(resultSet.getString(9));
                cliente.setNumero(resultSet.getInt(10));
                cliente.setBairro(resultSet.getString(11));
                cliente.setCidade(resultSet.getString(12));
                cliente.setEstado(resultSet.getString(13));
                cliente.setComplemento(resultSet.getString(14));
                
                clientes.add(cliente);
            }
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public void update(Cliente cliente, String cpfAntigo)
    {
        
    }
    
    public void delete(String cpf)
    {
        String sql = "delete from cliente where cpf = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            preparedStatement.executeQuery();
            preparedStatement.close();
            
            new PessoaDAO().delete(cpf);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
