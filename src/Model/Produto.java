package Model;

import java.util.HashMap;

public class Produto {
    
    private int codigo;
    private String nome;
    private float valor;
    private int quantidade;
    private HashMap<Integer, Item> itens = new HashMap<Integer, Item>();
    
    public Produto(int codigo, Item i)
    {
        this.setCodigo(codigo);
        itens.put(i.getCodigo(), i);
    }
        
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public void setValor(float valor){
        this.valor = valor;
    }
    
    public float getValor(){
        return valor;
    }    

    public void setNome(String nome) {
        this.nome = nome;
    }    
    
    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
        
    public HashMap<Integer, Item> getItens() {
        return itens;
    }

    public void setItens(HashMap<Integer, Item> itens) {
        this.itens = itens;
    }
    
    public void removerItens(Item item){
        itens.remove(item.getCodigo());
    }
    
    public void adicionarItens(Item item){
        itens.put(item.getCodigo(), item);
    }
}
