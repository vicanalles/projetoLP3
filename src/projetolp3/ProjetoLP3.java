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
        Cliente cliente;
        Funcionario funcionario;
        Fornecedor fornecedor;
        Item item;
        Produto produto;
        
        Controlador cn = new Controlador();
        
         do {
            cn.exibirMenu();
            op = entrada.nextInt();
            
            switch(op){
                
                case 1:
                    cliente = new Cliente();
                    System.out.println("Digite o CPF do cliente : ");
                    entrada.nextLine();
                    cliente.setCpf(entrada.nextLine());
                    if (cn.verificarCpf(cliente) == true)
                    {
                        System.out.println("Cliente ja cadastrado");
                        break;
                    }
                    
                    cliente.adicionarDados();        
                    cn.cadastrarCliente(cliente);
                    
                    break;
                
                case 2:
                    funcionario = new Funcionario();
                    System.out.println("Digite o CPF do funcionário: ");
                    entrada.nextLine();
                    funcionario.setCpf(entrada.nextLine());
                    if (cn.verificarCpf(funcionario) == true)
                    {
                        System.out.println("Funcionário ja cadastrado");
                        break;
                    }
                    
                    funcionario.adicionarDados();        
                    cn.cadastrarFuncionario(funcionario);
                    
                    break;
                    
                case 3:
                    fornecedor = new Fornecedor();
                    System.out.println("Digite o CNPJ: ");
                    entrada.nextLine();
                    fornecedor.setCnpj(entrada.nextLine());
                    if(cn.verificarCnpj(fornecedor) == true)
                    {
                        System.out.println("Fornecedor já cadastrado");
                        break;
                    }
                    fornecedor.adicionarDados();
                    cn.cadastrarFornecedor(fornecedor);
                    break;
                    
                case 4:
                    item = new Item();
                    System.out.println("Digite o código: ");
                    entrada.nextLine();
                    item.setCodigo(entrada.nextInt());
                    if(cn.verificarCodigoItem(item)== true)
                    {
                        System.out.println("Código já existente");
                        break;
                    }
                    item.adicionarDados();
                    cn.cadastrarItem(item);
                    
                    break;
                    
                case 5:
                    System.out.println("Digite o código do produto: ");
                    entrada.nextLine();
                    int codigoProduto = entrada.nextInt();
                    if(cn.verificarCodigoProduto(codigoProduto) == true)
                    {
                        System.out.println("Código já cadastrado");
                        break;
                    }
                    cn.listarItens();
                    System.out.println("Digite o código do item que deseja adicionar: ");
                    entrada.nextLine();
                    int codigoItem = entrada.nextInt();
                    item = cn.procurarItem(codigoItem);
                    produto = new Produto(codigoProduto, item);
                    produto.adicionarDados();
                    cn.cadastrarProduto(produto);
                    
                    break;
            }
            
        }while (op != 0);
        System.exit(0);
    }
    
}
