package projetolp3;

import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Pedido {
    
    private int numero;
    private String pagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Log log;    
    private ArrayList<Produto> produtos;
    
    public Pedido(int numero, int tipoPedido, Cliente cliente, Funcionario funcionario)
    {                      
        this.numero = numero;
        this.cliente = cliente;
        this.funcionario = funcionario;
        log = new Log(DataHora.getDate(), tipoPedido);
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
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public void exibirDados()
    {
        System.out.println("Pedido Nº: " + numero);
        System.out.print("Cliente: " + cliente.getNome());
        System.out.println("\tFuncionário: " + funcionario.getNome());
        System.out.println("Forma de pagamento: " + pagamento);
        
    }
    
    public void adicionarProduto(Produto produto)
    {
        produtos.add(produto);
    }
}
