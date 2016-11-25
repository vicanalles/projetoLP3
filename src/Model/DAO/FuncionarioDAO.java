package Model.DAO;

import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class FuncionarioDAO
{
    Connection connection;
    
    public FuncionarioDAO()
    {
        connection = ConnectionFactory.getInstance().getConnection();
    }
    
    public void create(Funcionario funcionario)
    {
        new PessoaDAO().create(funcionario);
        
        String sql = "insert into funcionario(cpf, funcao, salario) values(?, ?, ?);";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, funcionario.getCpf());
            preparedStatement.setString(2, funcionario.getFuncao());
            preparedStatement.setFloat(3, funcionario.getSalario());
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public Funcionario selectOneByCpf(String cpf)
    {
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, p.cep, p.rua, p.numero, p.bairro, p.cidade, p.estado, p.complemento, f.funcao, f.salario from pessoa p, funcionario f where p.cpf = ? and p.cpf = f.cpf;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            ResultSet resultSet = preparedStatement.executeQuery();                        
            
            Funcionario funcionario = new Funcionario();
            
            if(resultSet.next())
            {                
                funcionario.setCpf(resultSet.getString(1));
                funcionario.setNome(resultSet.getString(2));
                funcionario.setSexo(resultSet.getString(3));
                funcionario.setDataNasc(resultSet.getDate(4));
                funcionario.setEmail(resultSet.getString(5));
                funcionario.setTelefone(resultSet.getString(6));
                funcionario.setCep(resultSet.getString(7));
                funcionario.setRua(resultSet.getString(8));
                funcionario.setNumero(resultSet.getInt(9));
                funcionario.setBairro(resultSet.getString(10));
                funcionario.setCidade(resultSet.getString(11));
                funcionario.setEstado(resultSet.getString(12));
                funcionario.setComplemento(resultSet.getString(13));
                funcionario.setFuncao(resultSet.getString(14));
                funcionario.setSalario(resultSet.getFloat(15));
                                
                preparedStatement.close();                
            }                        
            return funcionario;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Funcionario> selectByCpf(String cpf)
    {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, p.cep, p.rua, p.numero, p.bairro, p.cidade, p.estado, p.complemento, f.funcao, f.salario from pessoa p, funcionario f where p.cpf like ? and p.cpf = f.cpf;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + cpf + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();                                                
            
            while(resultSet.next())
            {                
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCpf(resultSet.getString(1));
                funcionario.setNome(resultSet.getString(2));
                funcionario.setSexo(resultSet.getString(3));
                funcionario.setDataNasc(resultSet.getDate(4));
                funcionario.setEmail(resultSet.getString(5));
                funcionario.setTelefone(resultSet.getString(6));
                funcionario.setCep(resultSet.getString(7));
                funcionario.setRua(resultSet.getString(8));
                funcionario.setNumero(resultSet.getInt(9));
                funcionario.setBairro(resultSet.getString(10));
                funcionario.setCidade(resultSet.getString(11));
                funcionario.setEstado(resultSet.getString(12));
                funcionario.setComplemento(resultSet.getString(13));
                funcionario.setFuncao(resultSet.getString(14));
                funcionario.setSalario(resultSet.getFloat(15));
                                
                funcionarios.add(funcionario);
            }                        
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();            
        }
        return funcionarios;
    }
    
    public ArrayList<Funcionario> selectByName(String nome)
    {
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, p.cep, p.rua, p.numero, p.bairro, p.cidade, p.estado, p.complemento, f.funcao, f.salario from pessoa p, funcionario f where p.nome like ? and p.cpf = f.cpf;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nome + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
            
            while(resultSet.next())
            {
                Funcionario funcionario = new Funcionario();

                funcionario.setCpf(resultSet.getString(1));
                funcionario.setNome(resultSet.getString(2));
                funcionario.setSexo(resultSet.getString(3));
                funcionario.setDataNasc(resultSet.getDate(4));
                funcionario.setEmail(resultSet.getString(5));
                funcionario.setTelefone(resultSet.getString(6));
                funcionario.setCep(resultSet.getString(7));
                funcionario.setRua(resultSet.getString(8));
                funcionario.setNumero(resultSet.getInt(9));
                funcionario.setBairro(resultSet.getString(10));
                funcionario.setCidade(resultSet.getString(11));
                funcionario.setEstado(resultSet.getString(12));
                funcionario.setComplemento(resultSet.getString(13));
                funcionario.setFuncao(resultSet.getString(14));
                funcionario.setSalario(resultSet.getFloat(15));

                funcionarios.add(funcionario);
            }
            preparedStatement.close();
            return funcionarios;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void update(Funcionario funcionario, String cpfAntigo)
    {
        new PessoaDAO().update(funcionario, cpfAntigo);
        
        String sql = "update funcionario set funcao = ?, salario = ? where cpf = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, funcionario.getFuncao());
            preparedStatement.setFloat(2, funcionario.getSalario());
            preparedStatement.setString(3, funcionario.getCpf());
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete(String cpf)
    {                
        new PessoaDAO().delete(cpf);
        
        String sql = "delete from funcionario where cpf = ?;";
        
        try{
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            preparedStatement.execute();
            preparedStatement.close();            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
