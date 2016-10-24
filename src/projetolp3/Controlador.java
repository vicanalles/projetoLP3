
package projetolp3;


import java.awt.RenderingHints;
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
        
    public void exibirMenu(int numeroMenu)
    {
        switch(numeroMenu)
        {
            case 0:
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
                System.out.println("15 - Adicionar checkpoint a um pedido");
                System.out.println("Digite a opçao desejada: ");
                break;
                
            case 1:
                
        }
        
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
        Fornecedor fornecedor;
        Funcionario funcionario;
        Item item = new Item();
        Scanner entrada = new Scanner(System.in);
        
        boolean funcionou = false;
        
        System.out.println("Digite o Cpf do funcionario que efetuou a compra: ");
        funcionario = procurarFuncionario(entrada.nextLine());
        if(funcionario == null)
        {
            System.out.println("Funcionário não encontrado. ");
            return;
        }
        
        System.out.println("Digite o Cnpj do fornecedor: ");
        fornecedor = procurarFornecedor(entrada.nextLine());
        if(fornecedor == null)
        {
            System.out.println("Fornecedor não encontrado. ");
            return;
        }

        System.out.println("Digite o numero da Nota Fiscal: ");
        compra.setNotaFiscal(entrada.nextLine());

        if(verificarNotaFiscal(compra.getNotaFiscal()) == true)
        {
            System.out.println("Nota fiscal já existente.");
            return;
        }
        
        boolean continuarCadastrando = true;
        do
        {
            System.out.println("Que item deseja adicionar à compra?");
            System.out.println("1 - Adicionar item já cadastrado\n2 - Adicionar item ainda não cadastrado");
            {
                int opcao = entrada.nextInt();
                entrada.nextLine();

                if(opcao == 2)
                {
                    System.out.println("Cadastre o item e depois efetue a compra do mesmo.");
                    cadastrarItem();
                }
            }

            System.out.println("Digite o codigo do item: ");
            item.setCodigo(entrada.nextInt());
            entrada.nextLine();
            
            if(verificarCodigoItem(item) == true)
            {
                System.out.println("Digite a quantidade comprada: ");
                item.setQuantidade(entrada.nextFloat());
                entrada.nextLine();
                
                System.out.println("Deseja adicionar " + item.getQuantidade() + "x " + item.getDescricao() + " à compra?\n1 - Sim / 2 - Não");
                if(entrada.nextInt() == 1)
                {
                    item.setQuantidade(item.getQuantidade()+procurarItem(item.getCodigo()).getQuantidade());
                    itens.put(item.getCodigo(), item);
                }
                else
                {
                    System.out.println("Item não adicionado à compra.");
                }
                entrada.nextLine();
            }
            else
            {
                System.out.println("Item não cadastrado.");
            }
            
            System.out.println("Deseja continuar adicionando itens à compra?\n1 - Sim / 2 - Não");
            if(entrada.nextInt() == 2)
                continuarCadastrando = false;
            
            entrada.nextLine();
            
        }while(continuarCadastrando == true);
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
    
    public void editarItem()
    {
        Scanner entrada = new Scanner(System.in);
        Item item;
        
        System.out.println("Digite o código do Item: ");
        entrada.nextLine();
        int codigoItem = entrada.nextInt();
        item = procurarItem(codigoItem);
        if(verificarCodigoItem(item) == true)
        {
            item.editarDados();
            itens.replace(item.getCodigo(), item);
        }
        else
        {
            System.out.println("Item não registrado no sistema!");
            return;
        }
        System.out.println("Item alterado com sucesso!");
    }
    
    public void cadastrarProduto()
    {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        Item item2;
        Produto produto;
        
        System.out.println("Digite o código do produto: ");
            entrada.nextLine();
            int codigoProduto = entrada.nextInt();
            if(verificarCodigoProduto(codigoProduto) == true)
            {
                System.out.println("Código já cadastrado");                        
                return;
            }
            listarItens();
            System.out.println("Digite o código do item que deseja adicionar: ");
            entrada.nextLine();
            int codigoItem = entrada.nextInt();
            item2 = procurarItem(codigoItem); 
            if(item2 == null){
                System.out.println("Código de Item não existente!");
                return;
            }
            produto = new Produto(codigoProduto, item2);
            produto.adicionarDados();
            produtos.put(produto.getCodigo(), produto);
            Item item3;
            do
            {
                System.out.println("Deseja adicionar mais algum item ao Produto? (1 - Sim 0 - Não)");
                opcao = entrada.nextInt();
                if(opcao == 1){
                    listarItens();
                    System.out.println("Digite o código do item a ser adicionado:");
                    entrada.nextLine();
                    int codigoItem2 = entrada.nextInt();
                    item3 = procurarItem(codigoItem2);
                    if(item3 == null){
                        System.out.println("Código de Item não existente!");
                        return;                        
                    }else{
                        produto.adicionarItens(item3);
                        System.out.println("Item adicionado!");
                    }
                }                                        
            }while(opcao != 0);                                
            listarProdutos();
    }
    
    public void editarProduto()
    {
        Scanner entrada = new Scanner(System.in);
        Item item;
        Item item2;
        Produto produto;
        
        System.out.println("Digite o código do Produto: ");
        
                    entrada.nextLine();
                    int codigoProduto = entrada.nextInt();
                    produto = procurarProduto(codigoProduto);
                    if(verificarCodigoProduto(codigoProduto) == true)
                    {                        
                        System.out.println("Deseja remover algum item? ");
                        entrada.nextLine();
                        int decisao = entrada.nextInt();
                        if(decisao == 1){
                            System.out.println("Digite o código do item a ser removido: ");
                            int codigoItem2 = entrada.nextInt();
                            item = procurarItem(codigoItem2);
                            produto.removerItens(item);
                        }
                        
                        System.out.println("Deseja adicionar algum item? ");
                        int decisao2 = entrada.nextInt();
                        if(decisao2 == 1){
                            listarItens();
                            System.out.println("Digite o código do item escolhido: ");
                            int codigoItem3 = entrada.nextInt();
                            item2 = procurarItem(codigoItem3);
                            produto.adicionarItens(item2);
                        }
                    }
                    produto.editarDados();
                    produtos.replace(produto.getCodigo(), produto);
                    listarProdutos();
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
    
    public boolean verificarNotaFiscal (String notaFiscal)
    {
        return compras.containsKey(notaFiscal);
    }
    
    public void listarClientes()
    {
        for(Map.Entry<String, Cliente> cliente : clientes.entrySet())
        {
            cliente.getValue().exibirDados();
        }
    }
    
    public void listarFuncionarios()
    {
        for(Map.Entry<String, Funcionario> funcionario : funcionarios.entrySet())
        {
            funcionario.getValue().exibirDados();
        }
    }
    
    public void listarFornecedores()
    {
        for(Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet())
        {
            fornecedor.getValue().exibirDados();
        }
    }
    
    public void listarItens()
    {
        for(Map.Entry<Integer, Item> item : itens.entrySet())
        {
            item.getValue().exibirDados();
        }
    }
    
    public void listarProdutos(){
        for(Map.Entry<Integer, Produto> produto : produtos.entrySet())
        {
            produto.getValue().exibirDados();
        }        
    }
    
    public Item procurarItem(int codigo)
    {
        return itens.get(codigo);        
    }        
    
    public Produto procurarProduto(int codigo)
    {
        for(Map.Entry<Integer, Produto> produto : produtos.entrySet())
        {
            if(produto.getKey() == codigo)
                p = produtos.get(produto.getKey());
        }
        return p;
    }
    
    /**
     * Procura um funcionário na lista de funcionários
     * @param cpf O CPF do funcionário que deseja encontrar
     * @return Retorna o funcionário encontrado ou null, caso não exista um funcionário com o CPF especificado.
     */
    public Funcionario procurarFuncionario(String cpf)
    {
        for(Map.Entry<String, Funcionario> funcionario : funcionarios.entrySet())
        {
            if(funcionario.getValue().getCpf().equals(cpf))
            {
                return funcionario.getValue();
            }
        }
        return null;
    }
    
    /**
     * Procura um cliente na lista de clientes
     * @param cpf O CPF do cliente que deseja encontrar
     * @return Retorna o cliente encontrado ou null, caso não exista um cliente com o CPF especificado.
     */
    public Cliente procurarCliente(String cpf)
    {
        for(Map.Entry<String, Cliente> cliente : clientes.entrySet())
        {
            if(cliente.getValue().getCpf().equals(cpf))
            {
                return cliente.getValue();
            }
        }
        return null;
    }
    
    /**
     * Procura um fornecedor na lista de fornecedores
     * @param cnpj O CNPJ do fornecedor que deseja encontrar
     * @return Retorna o fornecedor encontrado ou null, caso não exista um fornecedor com o CNPJ especificado.
     */
    public Fornecedor procurarFornecedor(String cnpj)
    {
        for(Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet())
        {
            if(fornecedor.getValue().getCnpj().equals(cnpj))
            {
                return fornecedor.getValue();
            }
        }
        return null;
    }
    
    /**
     * Remove um cliente da lista de clientes.
     */
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
    
    /**
     * Remove um funcionário da lista de funcionários.
     */
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
    
    /**
     * Remove um fornecedor da lista de fornecedores.
     */
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
    
    /**
     * Remove um produto da lista de produtos.
     */
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
    
    /**
     * Abre um novo pedido.
     */
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
        for(Map.Entry<Integer, Pedido> pedido : pedidos.entrySet())
        {
            System.out.println("____________________________________________");
            pedido.getValue().exibirDados();
        }
    }
    
    public void removerPedido()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o numero do pedido que deseja remover: ");
        int numeroPedido = entrada.nextInt();
        entrada.nextLine();
        if(pedidos.remove(numeroPedido) != null)
        {
            System.out.println("Pedido removido.");
        }
        else
        {   
            System.out.println("Número de pedido não encontrado.");
        }
    }
    
    public void adicionarChekpoint()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o numero do pedido que deseja adicionar um checkpoint: ");
        int numeroPedido = entrada.nextInt();
        entrada.nextLine();
        Pedido pedido = pedidos.get(numeroPedido);
        if(pedido != null)
        {
            pedido.adicionarCheckpoint();
        }
        else
        {
            System.out.println("Pedido não encontrado.");
        }
    }
}