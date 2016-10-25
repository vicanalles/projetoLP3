package projetolp3;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Produto {
    
    private int codigo;
    private String nome;
    private float valor;
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
        
    public HashMap<Integer, Item> getItens() {
        return itens;
    }

    public void setItens(HashMap<Integer, Item> itens) {
        this.itens = itens;
    }
    
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        this.setNome(entrada.nextLine());
    }
    
    public void editarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do Produto: ");
        this.setNome(entrada.nextLine());
    }
    
    public void removerItens(Item item){
        itens.remove(item.getCodigo());
    }
    
    public void adicionarItens(Item item){
        itens.put(item.getCodigo(), item);
    }
    
    public void exibirDados()
    {
        System.out.println("Dados do Produto:");
        System.out.println("Código " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Valor Produto: " + this.getValor());    
        System.out.println("Itens: ");
        for(Map.Entry<Integer, Item> i : itens.entrySet())
            System.out.println(i.getValue().getQuantidade() + " x " + i.getValue().getNome());
    }
}
