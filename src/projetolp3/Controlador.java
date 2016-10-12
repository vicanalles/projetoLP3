
package projetolp3;


import java.util.HashMap;
import java.util.Map;


public class Controlador 
{
    HashMap<String, Cliente> clientes = new HashMap<String,Cliente>();
    HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
    HashMap<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
    HashMap<Integer, Item> itens = new HashMap<Integer, Item>();
    HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();
    
    public void exibirMenu()
    {
        System.out.println("==========MENU============");
        System.out.println("1-Cadastrar Cliente");
        System.out.println("2-Cadastrar Funcionario");
        System.out.println("3-Cadastrar Fornecedor");
        System.out.println("4-Efetuar Compra de itens");
        System.out.println("5-Realizar Venda");
        System.out.println("Digite a opçao desejada: ");
    }
    
    public void cadastrarCliente(Cliente cliente)
    {
        clientes.put(cliente.getCpf(), cliente);
    }
    
    public void cadastrarFuncionario(Funcionario funcionario)
    {
        funcionarios.put(funcionario.getCpf(), funcionario);
    }
    
    public void cadastrarFornecedor(Fornecedor fornecedor)
    {
        fornecedores.put(fornecedor.getCnpj(), fornecedor);
    }
    
    public void cadastrarItem(Item item)
    {
        itens.put(item.getCodigo(), item);
    }
    
    public void cadastrarProduto(Produto produto)
    {
        produtos.put(produto.getCodigo(), produto);
    }
    
    public boolean verificarCpf(Pessoa pessoa)
    {
        if(pessoa instanceof Cliente)
            return clientes.containsKey(pessoa.getCpf());
        else
            return funcionarios.containsKey(pessoa.getCpf());
    }
    
    public boolean verificarCnpj(Fornecedor fornecedor)
    {
        return fornecedores.containsKey(fornecedor.getCnpj());
    }
    
    public boolean verificarCodigoItem(Item item)
    {
        return itens.containsKey(item.getCodigo());
    }
    
    public boolean verificarCodigoProduto(int codigoProduto)
    {
        return produtos.containsKey(codigoProduto);
    }
    
    public void listarClientes()
    {
        for(Map.Entry<String, Cliente> pair : clientes.entrySet())
        {
            pair.getValue().exibirDados();
        }
    }
    
    public void listarFuncionarios()
    {
        for(Map.Entry<String, Funcionario> pair : funcionarios.entrySet())
        {
            pair.getValue().exibirDados();
        }
    }
    
    public void listarFornecedores()
    {
        for(Map.Entry<String, Fornecedor> pair : fornecedores.entrySet())
        {
            pair.getValue().exibirDados();
        }
    }
    
    public void listarItens()
    {
        for(Map.Entry<Integer, Item> pair : itens.entrySet())
        {
            pair.getValue().exibirDados();
        }
    }
    
    public Item procurarItem(int codigo)
    {
        for(Map.Entry<Integer, Item> pair : itens.entrySet())
        {
            if(pair.getKey() == codigo)
                return itens.get(pair.getKey());
        }
    }
}