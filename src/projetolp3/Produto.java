package projetolp3;
import java.util.ArrayList;
public class Produto {
    
    private int codigo;
    private String nome;
    private ArrayList<Item> itens;
    
    public Produto(Item i)
    {
        itens = new ArrayList<Item>();
        itens.add(i);
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

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void cadastrarProduto(){
        
    }
    
    public void alterarProduto(){
        
    }
    
    public void excluirProduto(){
        
    }
    
    public void adicionarItens(Item i){
        
    }
    
}
