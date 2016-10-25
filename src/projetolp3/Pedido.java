package projetolp3;

import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
    
    private int numero;
    private String pagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Log log;    
    //private HashMap<Integer, Produto> produtos;
    private ArrayList<Produto> produtos;
    
    public Pedido(int numero, int tipoPedido, Cliente cliente, Funcionario funcionario)
    {                      
        this.numero = numero;
        this.cliente = cliente;
        this.funcionario = funcionario;
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

    public ArrayList<Produto> getProdutos()
    {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos)
    {
        this.produtos = produtos;
    }
    /*
    public HashMap<Integer, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Integer, Produto> produtos) {
        this.produtos = produtos;
    }
    
    */
    /**
     *  Exibe os dados do pedido
     */
    public void exibirDados()
    {
        System.out.println("Pedido Nº: " + numero);
        System.out.print("Cliente: " + cliente.getNome());
        System.out.println("\tFuncionário: " + funcionario.getNome());
        System.out.println("Forma de pagamento: " + pagamento);
        if(log.VerificarFinalizacao())
            System.out.println("Pedido finalizado");
        else
            System.out.println("Pedido não finalizado");
    }
    
    /**
     * Adiciona um produto à lista de produtos do pedido
     * @param produto O produto a ser adicionado
     */
    public void adicionarProduto(Produto produto)
    {
        //produtos.put(produto.getCodigo(), produto);
        produtos.add(produto);
    }
    
    public void adicionarCheckpoint()
    {
        log.adicionarCheckPoint();
    }
}
