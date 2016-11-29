package Model;

import java.util.ArrayList;

public class Pedido {
    
    private int numero;
    private String pagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private float valorPedido;
    private Log log;
    private ArrayList<Produto> produtos;
    
    public Pedido()
    {
        
    }
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

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario()
    {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario)
    {
        this.funcionario = funcionario;
    }

    public Log getLog()
    {
        return log;
    }

    public void setLog(Log log)
    {
        this.log = log;
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
    
    public String getNomeCliente(){
        return this.cliente.getNome();
    }
    
    /**
     * Adiciona um produto à lista de produtos do pedido e atualiza o valor 
     * conforme novos produtos são adicionados
     * @param produto O produto a ser adicionado
     * @param quantidade A quantidade do produto que compõe o pedido
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
     * @return A posição do log que foi adicionada. Pode retornar entre 0 e 5 caso o checkpoint seja adicionado, ou -1 caso o pedido já esteja finalizado.
     */
    public int adicionarCheckpoint()
    {
        return log.adicionarCheckPoint();
    }

    
}
