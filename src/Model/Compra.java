package Model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Compra {
    
    private long notaFiscal;
    private float valorTotal;
    private Date data;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private HashMap<Integer, Item> itens;
    
    /**
     *Instancia uma nova compra
     * @param notaFiscal o numero da nota fiscal
     * @param valorTotal o valor todal da compra, que é a soma de todos os itens que a compõe
     * @param funcionario o funcionário que realizou a compra
     * @param fornecedor o fornecedor que forneceu os itens
     * @param novosItensCompra uma HashMap contendo os itens obtidos nessa compra
     * @param itensControlador a HashMap de itens cujas quantidades serão atualizadas conforme os itens dessa compra. Geralmente é a HashMap que representa o estoque.
     */
    public Compra(long notaFiscal, float valorTotal, Funcionario funcionario, Fornecedor fornecedor, HashMap<Integer, Item> novosItensCompra, HashMap<Integer, Item> itensControlador)
    {
        this.notaFiscal = notaFiscal;
        this.valorTotal = valorTotal;
        this.funcionario = funcionario;
        this.fornecedor = fornecedor;
        this.itens = novosItensCompra;
        this.data = DataHora.getDate();
        
        //para cada item comprado, atualiza a quantidade e o valor desse item na HashMap que representa o estoque
        for(Map.Entry<Integer, Item> item : novosItensCompra.entrySet())
        {
            itensControlador.get(item.getValue().getCodigo()).atualizarQuantidade(item.getValue().getQuantidade());
            itensControlador.get(item.getValue().getCodigo()).setValorCompra(item.getValue().getValorCompra());
        }
    }    
 
    /**
     *Retorna a data da compra
     * @return o numero da nota fiscal
     */
    public long getNotaFiscal() {
        return notaFiscal;
    }

    /**
     *Altera o numero da nota fiscal
     * @param notaFiscal o numero da nota fiscal
     */
    public void setNotaFiscal(long notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    /**
     *Retorna o valor total da compra
     * @return o valor total da compra
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     *Ajusta o valor total da compra
     * @param valortotal o valor total da compra
     */
    public void setValorTotal(float valortotal) {
        this.valorTotal = valortotal;
    }

    /**
     *Retorna a data da compra
     * @return a data da compra
     */
    public Date getData() {
        return data;
    }

    /**
     *Altera a data da compra
     * @param data a data da compra
     */
    public void setData(Date data) {
        this.data = data;
    }          

    public Funcionario getFuncionario()
    {
        return funcionario;
    }

    public Fornecedor getFornecedor()
    {
        return fornecedor;
    }

    public HashMap<Integer, Item> getItens()
    {
        return itens;
    }
    
    
}
