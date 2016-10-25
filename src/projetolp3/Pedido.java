package projetolp3;

import java.util.ArrayList;
import java.util.Map;

public class Pedido {
    
    private int numero;
    private String pagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private float valorPedido;
    private Log log;    
    //private HashMap<Integer, Produto> produtos;
    private ArrayList<Produto> produtos;
    
    public Pedido(int numero, int tipoPedido, Cliente cliente, Funcionario funcionario)
    {                      
        this.numero = numero;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.valorPedido = 0;
        log = new Log(tipoPedido);
        //produtos = new HashMap<Integer, Produto>();
        produtos = new ArrayList<Produto>();
    }   

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public float getValorPedido()
    {
        return valorPedido;
    }

    public void setValorPedido(float valorPedido)
    {
        this.valorPedido = valorPedido;
    }

    public ArrayList<Produto> getProdutos()
    {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos)
    {
        this.produtos = produtos;
    }
    
    /**
     *  Exibe os dados do pedido
     */
    public void exibirDados()
    {
        System.out.println("Pedido Nº: " + numero);
        System.out.print("Cliente: " + cliente.getNome());
        System.out.println("\tFuncionário: " + funcionario.getNome());
        System.out.print("Valor do pedido: " + valorPedido);
        System.out.println("\tForma de pagamento: " + pagamento);
        if(log.VerificarFinalizacao())
            System.out.println("Pedido finalizado");
        else
            System.out.println("Pedido não finalizado");
    }
    
    /**
     * Adiciona um produto à lista de produtos do pedido e atualiza o valor conforme novos produtos são adicionados
     * @param produto O produto a ser adicionado
     */
    public void adicionarProduto(Produto produto)
    {
        produtos.add(produto);
        atualizarValor(produto.getValor());
    }
    
    /**
     *Atualiza o valor do pedido conforme novos produtos são adicionados
     * @param valor
     */
    public void atualizarValor(float valor)
    {
        this.valorPedido += valor;
    }
    
    /**
     * Adiciona a data atual do sistema ao log do pedido.
     * A data a ser adicionada é o próximo checkpoint do log.
     * Pedidos que não incluirem produção ou entrega manterão nulas as Dates referentes a cada um.
     */
    public void adicionarCheckpoint()
    {
        log.adicionarCheckPoint();
    }
}
