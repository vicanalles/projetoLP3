package projetolp3;

import java.util.ArrayList;

import java.util.Date;

public class Compra {
    
    private String notaFiscal;
    private float valor;
    private Date data;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private ArrayList<Item> itens;
    
    public Compra(Funcionario func, Fornecedor f, Item i)
    {
        funcionario = func;
        fornecedor = f;
        itens = new ArrayList<Item>();
        itens.add(i);
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public void cadastrarCompra(){
        
    }
    
    public void alterarCompra(){
        
    }
    
    public void cancelarCompra(){
        
    }
    
    public void adicionarItens(Item i){
        
    }
    
}
