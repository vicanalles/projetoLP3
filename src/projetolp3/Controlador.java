
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
    
    public Controlador()
    {
        
    }
    
    /**
     *Exibe o menu de opções
     * @param numeroMenu o numero do menu a ser exibido
     */
    public void exibirMenu()
    {
        System.out.println("==========MENU============");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Cadastrar Funcionario");
        System.out.println("3 - Cadastrar Fornecedor");
        System.out.println("4 - Registrar Nota Fiscal de Compras");
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
        System.out.println("16 - Cadastrar Itens");
        System.out.println("17 - Listar Produtos");
        System.out.println("18 - Listar Itens");
        System.out.println("19 - Listar Clientes");
        System.out.println("20 - Listar Funcionários");
        System.out.println("21 - Listar Fornecedores");
        System.out.println("Digite a opçao desejada: ");
    }
    
    /**
     *Cadastra um novo cliente
     */
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
        Compra compra;
        Fornecedor fornecedor;
        Funcionario funcionario;
        Item item;
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
        String numeroNota = entrada.nextLine();

        if(verificarNotaFiscal(numeroNota) == true)
        {
            System.out.println("Nota fiscal já existente.");
            return;
        }
        
        boolean continuarCadastrando = true;
        float valorTotal = 0;
        HashMap<Integer, Item> novosItensCompra = new HashMap<Integer, Item>();
        
        do
        {
            item = new Item();
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
            listarItens();
            System.out.println("Digite o codigo do item: ");
            int codigoItem = entrada.nextInt();
            entrada.nextLine();
            
            if(verificarCodigoItem(codigoItem) == true)
            {               
                item.setCodigo(codigoItem);
                item.setNome(procurarItem(codigoItem).getNome());
                System.out.println("Digite a quantidade comprada: ");
                item.setQuantidade(entrada.nextFloat());                
                entrada.nextLine();
                System.out.println("Digite o valor unitário do item:");
                item.setValorCompra(entrada.nextFloat());    
                entrada.nextLine();
                
                System.out.println("Deseja adicionar " + item.getQuantidade() + "x " 
                        + item.getNome() + " à compra?\n1 - Sim / 2 - Não");
                if(entrada.nextInt() == 1)
                {
                    valorTotal += item.getQuantidade() * item.getValorCompra();
                    novosItensCompra.put(item.getCodigo(), item);                    
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
            
            System.out.println("Deseja continuar adicionando itens à compra?\n"
                    + "1 - Sim / 2 - Não");
            if(entrada.nextInt() == 2)
                continuarCadastrando = false;
            
            entrada.nextLine();
            
        }while(continuarCadastrando == true);        
        compra = new Compra(numeroNota, valorTotal, funcionario, fornecedor, 
                novosItensCompra, itens);
        
    }
    public void cadastrarItem()
    {
        Item item = new Item();
        Scanner entrada = new Scanner(System.in);
        
        boolean funcionou = false;
        
        while(funcionou == false)
        {
            System.out.println("Digite o código do item:");
            int codigoItem = entrada.nextInt();
            item.setCodigo(codigoItem);
            boolean teste = verificarCodigoItem(item.getCodigo());
            
            if(teste == true)
            {
                System.out.println("Código já existente!\n");                
            }
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
        int codigoItem = entrada.nextInt();
        entrada.nextLine();
        item = procurarItem(codigoItem);

        if(verificarCodigoItem(codigoItem) == true)
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
        Item item;
        Produto produto;
        
        System.out.println("Digite o código do produto: ");            
        int codigoProduto = entrada.nextInt();
        entrada.nextLine();        
        if(verificarCodigoProduto(codigoProduto) == true)
        {
            System.out.println("Código já cadastrado");                        
            return;
        }
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = entrada.nextLine();
        listarItens();
        System.out.println("Digite o código do item que deseja adicionar: ");
        int codigoItem = entrada.nextInt();
        entrada.nextLine();
        if(verificarCodigoItem(codigoItem) == false){
            System.out.println("Código de Item não existente!");
            return;
        }
        item = new Item();
        item.setCodigo(codigoItem);
        item.setNome(procurarItem(codigoItem).getNome());
        item.setValorCompra(procurarItem(codigoItem).getValorCompra());
        System.out.println("Digite a quantidade necessária de " + item.getNome() + " para o produto: ");
        item.setQuantidade(entrada.nextFloat());
        entrada.nextLine();
        produto = new Produto(codigoProduto, item);
        produto.setNome(nomeProduto);
        Item item2;
        float valorProduto = (item.getValorVenda() * item.getQuantidade());
        do
        {
            System.out.println("Deseja adicionar mais algum item ao Produto? (1 - Sim 0 - Não)");
            opcao = entrada.nextInt();
            entrada.nextLine();
            if(opcao == 1){
                listarItens();
                System.out.println("Digite o código do item a ser adicionado:");                
                int codigoItem2 = entrada.nextInt();
                entrada.nextLine();
                if(verificarCodigoItem(codigoItem2) == false){
                    System.out.println("Código de Item não existente!");
                    return;                        
                }else{
                    item2 = new Item();
                    item2.setCodigo(codigoItem2);
                    item2.setNome(procurarItem(codigoItem2).getNome());
                    item2.setValorCompra(procurarItem(codigoItem2).getValorCompra());
                    System.out.println("Digite a quantidade necessária de " + item2.getNome() + " para o produto: ");
                    item2.setQuantidade(entrada.nextFloat());
                    entrada.nextLine();
                    valorProduto += (item2.getValorVenda() * item2.getQuantidade());
                    produto.adicionarItens(item2);
                    System.out.println("Item adicionado!");
                }
            }                                        
        }while(opcao != 0);                
        System.out.println("O valor mínimo de venda do Produto é: " + valorProduto);
        System.out.println("Digite o valor da mão de obra: ");
        valorProduto += entrada.nextFloat();
        entrada.nextLine();
        produto.setValor(valorProduto);
        produtos.put(produto.getCodigo(), produto);        
        System.out.println("Produto adicionado com sucesso!");
    }
    
    public void editarProduto()
    {
        Scanner entrada = new Scanner(System.in);
        Item item;
        Item item2;
        Produto produto;
        
        System.out.println("Digite o código do Produto: ");        
        int codigoProduto = entrada.nextInt();
        entrada.nextLine();
        produto = procurarProduto(codigoProduto);
        if(verificarCodigoProduto(codigoProduto) == true)
        {                        
            System.out.println("Deseja remover algum item? ");            
            int decisao = entrada.nextInt();
            entrada.nextLine();
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
    
    public boolean verificarCodigoItem(int codigo)
    {
        return itens.containsKey(codigo);
    }
    
    public boolean verificarCodigoProduto(int codigoProduto)
    {
        return produtos.containsKey(codigoProduto);
    }
    
    public boolean verificarNotaFiscal (String notaFiscal)
    {
        return compras.containsKey(notaFiscal);
    }
    
    /**
     *Exibe todos os clientes cadastrados
     */
    public void listarClientes()
    {
        for(Map.Entry<String, Cliente> cliente : clientes.entrySet())
        {
            System.out.println("____________________________________");
            cliente.getValue().exibirDados();
        }
    }
    
    /**
     *Exibe todos os funcionarios cadastrados
     */
    public void listarFuncionarios()
    {
        for(Map.Entry<String, Funcionario> funcionario : funcionarios.entrySet())
        {
            System.out.println("____________________________________");
            funcionario.getValue().exibirDados();
        }
    }
    
    /**
     *Exibe todos os fornecedores cadastrados
     */
    public void listarFornecedores()
    {
        for(Map.Entry<String, Fornecedor> fornecedor : fornecedores.entrySet())
        {
            System.out.println("____________________________________");
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
        return produtos.get(codigo);
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
        
        
        do
        {
            System.out.println("Que produto deseja adicionar à compra?");
            System.out.println("1 - Adicionar produto já cadastrado\n2 - Adicionar produto ainda não cadastrado\n3 - Finalizar Pedido");
            {
                int opcao = entrada.nextInt();
                entrada.nextLine();

                if(opcao == 2)
                {
                    System.out.println("Cadastre o produto e depois efetue a venda do mesmo.");
                    cadastrarProduto();
                }
                if(opcao == 3)
                {
                if(pedido.getProdutos().isEmpty() == true)
                {
                    System.out.print("Não pode sair. É necessário pelo menos um produto no pedido.");
                    continue;
                }
                else
                {
                    break;
                }    
                }
            }
            listarProdutos();
            System.out.println("Digite o codigo do produto: ");
            int codigo = entrada.nextInt();
            entrada.nextLine();
            
            Produto produto = procurarProduto(codigo);
            if(produto == null)
            {
                System.out.println("Produto de código " + codigo + " não encontrado.");
            }
            else
            {
                System.out.println("Digite a quantidade do produto:");
                int qtde = entrada.nextInt();
                entrada.nextLine();
                
                boolean itensSuficientes = true;
                //verifica se tem itens suficientes no estoque para vender esse produto
                for(Map.Entry<Integer, Item> item : produto.getItens().entrySet())
                {
                    if((item.getValue().getQuantidade() * qtde) > itens.get(item.getValue().getCodigo()).getQuantidade())
                    {
                        System.out.println("Não há ingredientes suficientes para venda desse produto.");
                        itensSuficientes = false;
                        break;
                    }
                }
                if(itensSuficientes == true)
                {
                    System.out.println("Produto adicionado ao pedido.");
                    for(int i=0;i<qtde;i++)
                        pedido.adicionarProduto(produto);
                }
            }
        }while (true);
        
        System.out.println("Digite a forma de pagamento: ");
        pedido.setPagamento(entrada.nextLine());
        
        for(Produto produto : pedido.getProdutos())
        {
            for(Map.Entry<Integer, Item> item : produto.getItens().entrySet())
            {
                itens.get(item.getValue().getCodigo()).atualizarQuantidade(item.getValue().getQuantidade() * (-1));
            }
        }
        
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