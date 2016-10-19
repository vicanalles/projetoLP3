package projetolp3;
import java.util.Scanner;

public class Item {
    
    private int codigo;
    private String nome;
    private String descricao;
    private float quantidade;
    private float valorcompra;
    private float valorvenda;

    public Item(){
        
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }
    
    public float getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(float valorcompra) {
        this.valorcompra = valorcompra;
    }

    public float getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(float valorvenda) {
        this.valorvenda = valorvenda;
    }
    
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do item: ");
        this.setNome(entrada.nextLine());
        System.out.println("Digite a descrição: ");
        this.setDescricao(entrada.nextLine());
        System.out.println("Digite a quantidade: ");
        this.setQuantidade(entrada.nextFloat());
        System.out.println("Digite o valor unitario: ");
        this.setValorcompra(entrada.nextFloat());
        
    }
    
    public void editarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do item: ");
        this.setNome(entrada.nextLine());
        System.out.println("Digite a descrição do item: ");
        this.setDescricao(entrada.nextLine());
        System.out.println("Digite a quantidade do item no estoque: ");
        this.setQuantidade(entrada.nextInt());
    }
    
    public void exibirDados()
    {
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Quantidade em estoque: " + this.getQuantidade());
    }
}
