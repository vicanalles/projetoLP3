package projetolp3;

import com.sun.javafx.collections.MapAdapterChange;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Compra {
    
    private String notaFiscal;
    private float valorTotal;
    private Date data;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private HashMap<Integer, Item> itens;
    
   public Compra(String notaFiscal, float valorTotal, Funcionario func, Fornecedor f, HashMap<Integer, Item> novosItensCompra, HashMap<Integer, Item> itensControlador)
    {
        this.notaFiscal = notaFiscal;
        this.valorTotal = valorTotal;
        this.funcionario = func;
        this.fornecedor = f;
        this.itens = novosItensCompra;
        this.data = DataHora.getDate();
        
        for(Map.Entry<Integer, Item> item : novosItensCompra.entrySet())
        {
            itensControlador.get(item.getValue().getCodigo()).atualizarQuantidade(item.getValue().getQuantidade());
            itensControlador.get(item.getValue().getCodigo()).setValorCompra(item.getValue().getValorCompra());
        }
    }    
 
    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valortotal) {
        this.valorTotal = valortotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }          
}
