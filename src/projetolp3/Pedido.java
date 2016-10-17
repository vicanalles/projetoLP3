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
    
    public Pedido(Cliente cliente, Funcionario funcionario, Produto produto)
    {                        
        this.cliente = cliente;
        this.funcionario = funcionario;
        //DataHora dh = new DataHora();
        log = new Log(DataHora.getDate());
        produtos = new ArrayList<Produto>();
        produtos.add(produto);
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
    
    public void cadastrarPedido()
    {
        
    }
    public void alterarPedido()
    {
        
    }
    
    public void cancelarPedido(){
        
    }
}
