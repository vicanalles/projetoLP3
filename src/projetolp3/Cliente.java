package projetolp3;
import java.util.Date;
import java.util.Scanner;

public class Cliente extends Pessoa {
    
    private String produtoFavorito;
    
    public Cliente()
    {
        
    }
        
    /**
     * Retorna o produto favorito do cliente
     * @return produto favorito do cliente
     */
    public String getProdutoFavorito() {
        return produtoFavorito;
    }

    /**
     * Altera o produto favorito  do cliente 
     * @param produtoFavorito Nome do produto favorito do cliente
     */
    public void setProdutoFavorito(String produtoFavorito) {
        this.produtoFavorito = produtoFavorito;
    }   
    
    /**
     *Exibe todos os dados do cliente
     */
    public void exibirDados()
    {
        System.out.println("Dados do cliente:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Sexo: " + this.getSexo());
        System.out.println("Produto Favorito: " + this.getProdutoFavorito());
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
    
    /**
     *Adiciona os dados do cliente
     */
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite o nome do cliente:");
        this.setNome(entrada.nextLine());
        System.out.println("Digite o sexo M/F:");
        this.setSexo(entrada.nextLine());
        System.out.println("Digite a data de nascimento no formato dd/MM/yyyy:");
        Date dataConvertida = new Date();
        
        boolean funcionou;
        funcionou = false;
        while(funcionou == false)//fica no loop enquanto a data recebida não estiver no formato especificado
        {
            String data = entrada.nextLine();
            try
            {
                dataConvertida = DataHora.converterData(data);
                funcionou = true;
            }
            catch(Exception e)
            {
                System.out.println("Data invalida! Digite a data Novamente:");

            }
        }
        this.setDataNasc(dataConvertida);
        System.out.println("Digite o e-mail:");
        this.setEmail(entrada.nextLine());
        System.out.println("Digite telefone");
        this.setTelefone(entrada.nextLine());
        System.out.println("Digite o cep:");
        this.setCep(entrada.nextLine());
        System.out.println("Digite Rua:");
        this.setRua(entrada.nextLine());
        System.out.println("Digite o numero:");
        this.setNumero(entrada.nextInt());
        entrada.nextLine();
        System.out.println("Digite o bairro:");
        this.setBairro(entrada.nextLine());
        System.out.println("Digite a cidade:");
        this.setCidade(entrada.nextLine());
        System.out.println("Digite o complemento:");
        this.setComplemento(entrada.nextLine());
        System.out.println("Digite o Estado:");
        this.setEstado(entrada.nextLine());
        System.out.println("Digite o produto favorito:");
        this.setProdutoFavorito(entrada.nextLine());
       
    }
}
