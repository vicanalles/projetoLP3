package projetolp3;

public class Cliente extends Pessoa {
    
    private int numeroFilhos;
    
    public Cliente()
    {
        
    }
    
    public Cliente(Cliente c){
        
    }
        
    public int getNumeroFilhos() {
        return numeroFilhos;
    }

    public void setNumeroFilhos(int numeroFilhos) {
        this.numeroFilhos = numeroFilhos;
    }   
    
    
    public void alterarCliente()
    {
        
    }
    public void excluirCliente()
    {
        
    }
    
    public void exibirDados()
    {
        System.out.println("Dados do cliente:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getNome());
        System.out.println("Sexo: " + this.getSexo());
        System.out.println("Data de Nascimento: " + this.getDataNasc());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Telefone: " + this.getTelefone());
        System.out.println("CEP: " + this.getCep());
        System.out.print("Rua: " + this.getRua());
        System.out.println("\tNº: " + this.getNumero());
        System.out.println("Bairro: " + this.getBairro());
        System.out.println("Cidade: " + this.getCidade());
        System.out.println("Estado: " + this.getEstado());
        System.out.println("Complemento: " + this.getComplemento());
    }
}
