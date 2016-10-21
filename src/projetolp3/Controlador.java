
package projetolp3;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controlador 
{
    Item i;
    Produto p;
    HashMap<String, Cliente> clientes = new HashMap<String,Cliente>();
    HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
    HashMap<String, Fornecedor> fornecedores = new HashMap<String, Fornecedor>();
    HashMap<Integer, Item> itens = new HashMap<Integer, Item>();
    HashMap<Integer, Produto> produtos = new HashMap<Integer, Produto>();
    HashMap<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
    HashMap<String, Compra> compras = new HashMap<String, Compra>(); 
        
    public void exibirMenu()
    {
        System.out.println("==========MENU============");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Funcionario");
        System.out.println("3 - Cadastrar Fornecedor");
        System.out.println("4 - Efetuar Compra de itens");
        System.out.println("5 - Registrar novo Produto");
        System.out.println("6 - Editar Itens");
        System.out.println("7 - Editar Produtos");
        System.out.println("8 - Remover Cliente");
        System.out.println("9 - Remover Funcionario");
        System.out.println("10 - Remover Fornecedor");
        System.out.println("11 - Remover Produto");
        System.out.println("12 - Abrir pedido");
        System.out.println("13 - Listar pedidos");
        System.out.println("14 - Remover pedido");
        System.out.println("Digite a opçao desejada: ");
    }
    
    public void cadastrarCliente()
    {
        Cliente cliente = new Cliente();
        Scanner entrada = new Scanner(System.in);
        
        boolean funcionou = false;
        while(funcionou == false)
        {
            System.out.println("Digite o CPF do cliente: ");
            cliente.setCpf(entrada.nextLine());
            
            if(verificarCpf(cliente) == true)
            {
                System.out.println("CPF já cadastrado. ");
            }
                
            else
            {
                funcionou = true;
            }
                
        }
        cliente.adicionarDados(); 
        clientes.put(cliente.getCpf(), cliente);
    }
    
    public void cadastrarFuncionario()
    {
        Funcionario funcionario = new Funcionario();
        Scanner entrada = new Scanner(System.in);
        
        boolean funcionou;
        
        funcionou = false;
        while(funcionou == false)
        {
            System.out.println("Digite o CPF do funcionário: ");
            funcionario.setCpf(entrada.nextLine());
            
            if (verificarCpf(funcionario) == true)
                System.out.println("CPF já cadastrado. ");
            else
                funcionou = true;
        }
        
        funcionario.adicionarDados();
        funcionarios.put(funcionario.getCpf(), funcionario);
    }
    
    public void cadastrarFornecedor()
    {
        Fornecedor fornecedor = new Fornecedor();
        Scanner entrada = new Scanner(System.in);
        
        boolean funcionou = false;        
        
        while(funcionou == false)
        {
            System.out.println("Digite o CNPJ do fornecedor:");
            fornecedor.setCnpj(entrada.nextLine());
            
            if(verificarCnpj(fornecedor) == true)
                System.out.println("CNPJ já cadastrado.");
            else
                funcionou = true;
        }
        fornecedor.adicionarDados();
        fornecedores.put(fornecedor.getCnpj(), fornecedor);
    }
    
    public void cadastrarCompra()
    {
        Compra compra = new Compra();
        Fornecedor fornecedor = new Fornecedor();
        Item item = new Item();
        Funcionario funcionario = new Funcionario();
        float qtd = 0;
        Scanner entrada = new Scanner(System.in);
        
        
        boolean funcionou = false;
        
        while (funcionou == false)
        {
            System.out.println("Digite o numero da Nota Fiscal: ");
            compra.setNotaFiscal(entrada.nextLine());
            
            if(verificarNotaFiscal(compra) == true)
            {
                System.out.println("Digite o Cnpj do fornecedor: ");
                fornecedor.setCnpj(entrada.nextLine());
                
                if(verificarCnpj(fornecedor) == true)
                {
                    System.out.println("Digite o Cpf do funcionario que efetuou a compra: ");
                    funcionario.setCpf(entrada.nextLine());
                    
                    if(verificarCpf(funcionario) == true)
                    {
                        System.out.println("Digite o codigo do item comprado: ");
                        item.setCodigo(entrada.nextInt());
                        
                        if(verificarCodigoItem(item) == true)
                        {
                            System.out.println("Deseja Efetuar compra de: " + item.getDescricao() + "S/N");
                            
                            System.out.println("Digite a quantidade comprada: ");
                            qtd = (entrada.nextFloat());
                           
                            
                        }
                        else
                        {
                            
                        }
                    } 
                }
            }
        }
    }
    public void cadastrarItem()
    {
        Item item = new Item();
        Scanner entrada = new Scanner(System.in);
        
        boolean funcionou = false;
        
        while(funcionou == false)
        {
            System.out.println("Digite o código do item:");
            item.setCodigo(entrada.nextInt());
            
            if(verificarCodigoItem(item) == true)
                System.out.println("Código já existente!");
            else
                funcionou = true;
        }        
        item.adicionarDados();
        itens.put(item.getCodigo(), item);
        System.out.println("Item cadastrado com sucesso!");
    }
    
    public void editarItem(Item item)
    {
        itens.replace(item.getCodigo(), item);
    }
    
    public void cadastrarProduto(Produto produto)
    {
        produtos.put(produto.getCodigo(), produto);
    }
    
    public void editarProduto(int codigo, Produto produto)
    {
        produtos.replace(produto.getCodigo(), produto);
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
    
    public boolean verificarNotaFiscal (Compra compra)
    {
        return compras.containsKey(compra.getNotaFiscal());
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
    
    public void listarProdutos(){
        for(Map.Entry<Integer, Produto> pair : produtos.entrySet())
        {
            pair.getValue().exibirDados();
        }        
    }
    
    public Item procurarItem(int codigo)
    {
        for(Map.Entry<Integer, Item> pair : itens.entrySet())
        {
            if(pair.getKey() == codigo)
                 i = itens.get(pair.getKey());            
        }
        return i;        
    }        
    
    public Produto procurarProduto(int codigo)
    {
        for(Map.Entry<Integer, Produto> pair : produtos.entrySet())
        {
            if(pair.getKey() == codigo)
                p = produtos.get(pair.getKey());
        }
        return p;
    }
    
    public Funcionario procurarFuncionario(String cpf)
    {
        for(Map.Entry<String, Funcionario> pair : funcionarios.entrySet())
        {
            if(pair.getValue().getCpf().equals(cpf))
            {
                return pair.getValue();
            }
        }
        return null;
    }
    
    public Cliente procurarCliente(String cpf)
    {
        for(Map.Entry<String, Cliente> pair : clientes.entrySet())
        {
            if(pair.getValue().getCpf().equals(cpf))
            {
                return pair.getValue();
            }
        }
        return null;
    }
    
    public void removerCliente()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente que deseja remover: ");
        String cpf = entrada.nextLine();
        if(clientes.remove(cpf) == null)
            System.out.println("CPF de cliente não encontrado.");
        else
            System.out.println("Cliente removido com sucesso.");
        
    }
    
    public void removerFuncionario()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CPF do funcionario que deseja remover: ");
        String cpf = entrada.nextLine();
        if(funcionarios.remove(cpf) == null)
            System.out.println("CPF de funcionário não encontrado.");
        else
            System.out.println("Funcionário removido com sucesso.");
    }
    
    public void removerFornecedor()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CNPJ do fornecedor que deseja remover: ");
        String cnpj = entrada.nextLine();
        if(fornecedores.remove(cnpj) == null)
            System.out.println("CNPJ de fornecedor não encontrado.");
        else
            System.out.println("Fornecedor removido com sucesso.");
    }
    
    public void removerProduto()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o código do produto que deseja remover: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        
        if(produtos.remove(codigo) == null)
            System.out.println("Código de produto não encontrado.");
        else
            System.out.println("Produto removido com sucesso.");
    }
    
    public void abrirPedido()
    {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o CPF do Funcionario: ");
        String cpfFuncionario = entrada.nextLine();
        Funcionario funcionario = procurarFuncionario(cpfFuncionario);
        if(funcionario == null)
        {
            System.out.println("Funcionário não encontrado");
            return;
        }
        
        System.out.println("Digite o CPF do Cliente: ");
        String cpfCliente = entrada.nextLine();
        Cliente cliente = procurarCliente(cpfCliente);
        if(cliente == null)
        {
            System.out.println("Cliente não encontrado");
            return;
        }
        
        int numeroPedido;
        while(true)
        {
            System.out.println("Digite o número do pedido:");
            numeroPedido = entrada.nextInt();
            entrada.nextLine();
            if(pedidos.containsKey(numeroPedido))
                System.out.println("Número de pedido já existente.");
            else
                break;
        }
        
        boolean comProducao = false;
        boolean comEntrega = false;
        
        System.out.println("O pedido inclui produção?\n0 - Não 1 - Sim");
        if(entrada.nextInt() == 1)
            comProducao = true;

        System.out.println("O pedido inclui entrega?\n0 - Não 1 - Sim");
        if(entrada.nextInt() == 1)
            comEntrega = true;
        
        int tipoPedido = 0;
        if(comProducao == false && comEntrega == false)
            tipoPedido = 0;
        else if(comProducao == true && comEntrega == false)
            tipoPedido = 1;
        else if(comProducao == false && comEntrega == true)
            tipoPedido = 2;
        else if(comProducao == true && comEntrega == true)
            tipoPedido = 3;
        
        Pedido pedido = new Pedido(numeroPedido, tipoPedido, cliente, funcionario);
        
        System.out.println("Lista de produtos: ");
        listarProdutos();
        int codigo;
        do
        {
            System.out.println("É necessário pelo menos um produto no pedido.\nDigite o código de um produto ou 0 para sair: ");
            codigo = entrada.nextInt();
            entrada.nextLine();
            if(codigo == 0)
            {
                if(pedido.getProdutos().isEmpty() == true)
                {
                    System.out.print("Não pode sair. ");
                    continue;
                }
                else
                {
                    break;
                }    
            }
            
            Produto produto = procurarProduto(codigo);
            if(produto == null)
            {
                System.out.println("Produto de código " + codigo + " não encontrado.");
            }
            else
            {
                System.out.println("Produto adicionado ao pedido.");
                pedido.adicionarProduto(produto);
            }
        }while (true);
        
        System.out.println("Digite a forma de pagamento: ");
        pedido.setPagamento(entrada.nextLine());
        
        pedidos.put(pedido.getNumero(), pedido);
        System.out.println("Pedido criado com sucesso");
    }
    
    public void listarPedidos()
    {
        
    }
    
    public void removerPedido()
    {
        
    }
}