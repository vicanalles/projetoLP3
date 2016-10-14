package projetolp3;

import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    
    private int codigo;
    private String nome;
    private ArrayList<Item> itens = new ArrayList<Item>();
    
    public Produto(int codigo, Item i)
    {
        this.setCodigo(codigo);
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
        itens.remove(item);
    }
    
    public void adicionarItens(Item item){
        itens.add(item);
    }
    
    public void exibirDados()
    {
        System.out.println("Dados do Produto:");
        System.out.println("Código " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        for(Item i : itens)
            System.out.println("Itens: " + i.getNome());
    }
}
