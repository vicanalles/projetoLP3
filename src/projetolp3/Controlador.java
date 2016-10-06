
package projetolp3;


import java.util.HashMap;


public class Controlador 
{
    
    
    HashMap<String,Cliente> clientes = new HashMap<String,Cliente>();
    
    public void exibirMenu()
    {
        System.out.println("==========MENU============");
        System.out.println("1-Cadastrar Cliente");
        System.out.println("2-Cadastrar Fornecedor");
        System.out.println("3-Cadastrar Funcionario");
        System.out.println("4-Efetuar Compra de itens");
        System.out.println("5-Realizar Venda");
        System.out.println("Digite a opçao desejada: ");
    }
    
    public void cadastrarCliente(Cliente c)
    {
        clientes.put(c.getCpf(),c);
    }
    
    public boolean verificarCpf(Cliente cliente)
    {
        return clientes.containsKey(cliente.getCpf());
    }
}