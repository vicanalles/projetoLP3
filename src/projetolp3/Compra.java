package projetolp3;

import java.util.ArrayList;

import java.util.Date;
import java.util.Scanner;

public class Compra {
    
    private String notaFiscal;
    private float valortotal;
    private Date data;
    private Funcionario funcionario;
    private Fornecedor fornecedor;
    private ArrayList<Item> itens;
    
   /* public Compra(Funcionario func, Fornecedor f, Item i)
    {
        funcionario = func;
        fornecedor = f;
        itens = new ArrayList<Item>();
        itens.add(i);
    }*/
    public Compra ()
    {
    
    }

 
    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public float getValorTotal() {
        return valortotal;
    }

    public void setValorTotal(float valortotal) {
        this.valortotal = valortotal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public void cadastrarCompra(){
       Scanner entrada = new Scanner(System.in);
       
    }
    
    public void alterarCompra(){
        
    }
    
    public void cancelarCompra(){
        
    }
    
    public void adicionarItens(Item i){
        
    }
    
}
