//comentário de teste

package projetolp3;

import java.text.DateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ProjetoLP3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {        
        
        Scanner entrada = new Scanner(System.in);
        int op;
        Cliente c;
        Controlador cn = new Controlador();
        
         do {
            cn.exibirMenu();
            op = entrada.nextInt();
            
            switch(op){
                
                case 1 : 
                    String cpf = new String();
                    c = new Cliente();
                    System.out.println("Digite o CPF do cliente : ");
                    entrada.nextLine();
                    cpf = entrada.nextLine();
                    c.setCpf(cpf);
                    if (cn.verificarCpf(c) == true)
                    {
                        System.out.println("Cliente ja cadastrado");
                        break;
                    }
                    System.out.println("Digite o nome do cliente :");
                    c.setNome(entrada.nextLine());
                    System.out.println("Digite o sexo M/F :");
                    entrada.nextLine();
                    c.setSexo(entrada.next().charAt(0));
                    System.out.println("Digite a data de nascimento no formato dd/MM/yyyy : ");
                    Date dataConvertida = new Date();
                    boolean funcionou = false;
                    while(funcionou == false)
                    {
                        entrada.nextLine();
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
                    c.setDataNasc(dataConvertida);
                    System.out.println("Digite o e-mail");
                    c.setEmail(entrada.nextLine());
                    System.out.println("Digite telefone");
                    c.setTelefone(entrada.nextLine());
                    System.out.println("Digite o cep");
                    c.setCep(entrada.nextLine());
                    System.out.println("Digite Rua");
                    c.setRua(entrada.nextLine());
                    System.out.println("Digite o numero");
                    c.setNumero(entrada.nextInt());
                    System.out.println("Digite o bairro");
                    entrada.nextLine();
                    c.setBairro(entrada.nextLine());
                    System.out.println("Digite a cidade");
                    c.setCidade(entrada.nextLine());
                    System.out.println("Digite o complemento");
                    c.setComplemento(entrada.nextLine());
                    System.out.println("Digite o Estado");
                    c.setEstado(entrada.nextLine());
                    System.out.println("Digite o numero de filhos");
                    c.setNumeroFilhos(entrada.nextInt());
                    entrada.nextLine();
                    
                    cn.cadastrarCliente(c);
                    
                    cn.listarClientes();
                    
                    break;
            }
            
        }while (op != 0);
        System.exit(0);
    }
    
}
