package projetolp3;
import java.util.ArrayList;
import java.util.Scanner;

public class Produto {
    
    private int codigo;
    private String nome;
    private ArrayList<Item> itens;
    
    public Produto(int codigo, Item i)
    {
        this.setCodigo(codigo);
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
    
    public void adicionarItens(Item item){
        
    }
    
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        this.setNome(entrada.nextLine());
    }
}
