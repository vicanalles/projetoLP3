package projetolp3;

import java.util.Date;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    
    private String funcao;
    private float salario;
    
    public Funcionario()
    {
        
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }        
    
    public void cadastrarFuncionario()
    {
        
    }
    public void alterarFuncionario()
    {
        
    }
    public void excluirFuncionario()
    {
        
    }
    
    public void exibirDados()
    {
        System.out.println("Dados do funcionário:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("Função: " + this.getFuncao());
        System.out.println("Salário: " + this.getSalario());
        System.out.println("CPF: " + this.getCpf());
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
    
    public void adicionarDados()
    {
        Scanner entrada = new Scanner(System.in);
        Controlador controlador = new Controlador();
        
        System.out.println("Digite o nome do funcionário: ");
        this.setNome(entrada.nextLine());
        System.out.println("Digite a função: ");
        this.setFuncao(entrada.nextLine());
        System.out.println("Digite o salário: ");
        this.setSalario(entrada.nextFloat());
        entrada.nextLine();
        System.out.println("Digite o sexo M/F:");
        this.setSexo(entrada.nextLine());
        System.out.println("Digite a data de nascimento no formato dd/MM/yyyy:");
        Date dataConvertida = new Date();
        
        boolean funcionou = false;
        while(funcionou == false)
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
        System.out.println("Digite o bairro:");
        entrada.nextLine();
        this.setBairro(entrada.nextLine());
        System.out.println("Digite a cidade:");
        this.setCidade(entrada.nextLine());
        System.out.println("Digite o complemento:");
        this.setComplemento(entrada.nextLine());
        System.out.println("Digite o Estado:");
        this.setEstado(entrada.nextLine());
    }
}
