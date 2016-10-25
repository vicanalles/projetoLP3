package projetolp3;
import java.util.Scanner;

public class Item {
    
    private int codigo;
    private String nome;
    private String descricao;
    private float quantidade = 0;
    private float valorCompra = 0;

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
    
    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    public float getValorVenda(){
        return valorCompra * 1.3f;
    }
    
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do item: ");
        this.setNome(entrada.nextLine());
        System.out.println("Digite a descrição: ");
        this.setDescricao(entrada.nextLine());        
    }
    
    public void editarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do item: ");
        this.setNome(entrada.nextLine());
        System.out.println("Digite a descrição do item: ");
        this.setDescricao(entrada.nextLine());
    }
    
    public void exibirDados()
    {
        System.out.println("\nCódigo: " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Quantidade em estoque: " + this.getQuantidade());
        System.out.println("Valor do Item: " + this.getValorCompra()); 
    }
    
    public void atualizarQuantidade(float quantidade)
    {
        this.quantidade += quantidade;
    }
    
    public void atualizarValor(float valor)
    {
        this.valorCompra = valor;
    }
}
