package projetolp3;
import java.util.Scanner;

public class Fornecedor {
    
    private String cnpj;
    private String nome;
    private String nomeFantasia;
    private String cep;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    
    public Fornecedor()
    {
        
    }
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public void cadastrarFornecedor()
    {
        
    }
    public void alterarFornecedor()
    {
        
    }
    public void excluirFornecedor()
    {
        
    }
    
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o CNPJ: ");
        this.setCnpj(entrada.nextLine());
        System.out.println("Digite o nome");
        this.setNome(entrada.nextLine());
        System.out.println("Digite o nome fantasia: ");
        this.setNomeFantasia(entrada.nextLine());
        System.out.println("Digite o CEP: ");
        this.setCep(entrada.nextLine());
        System.out.println("Digite o nome da Rua: ");
        this.setRua(entrada.nextLine());
        System.out.println("Digite o numero: ");
        this.setNumero(entrada.nextInt());
        System.out.println("Digite o bairro: ");
        entrada.nextLine();
        this.setBairro(entrada.nextLine());
        System.out.println("Digite o nome da cidade: ");
        this.setCidade(entrada.nextLine());
        System.out.println("Digite o estado: ");
        this.setEstado(entrada.nextLine());
        System.out.println("Digite o complemento: ");
        this.setComplemento(entrada.nextLine());
    }
    
    public void exibirDados()
    {
        System.out.println("Dados do fornecedor: ");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CNPJ: " + this.getCnpj());
        System.out.println("Nome fantasia: " + this.getNomeFantasia());
        System.out.println("CEP: " + this.getCep());
        System.out.print("Rua: " + this.getRua());
        System.out.println("\tNº: " + this.getNumero());
        System.out.println("Bairro: " + this.getBairro());
        System.out.print("Cidade: " + this.getCidade());
        System.out.println("\tEstado: " + this.getEstado());
        System.out.println("Complemento: " + this.getComplemento());
    }
}
