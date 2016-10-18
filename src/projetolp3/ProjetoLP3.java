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
        int opcao;
        Cliente cliente;
        Funcionario funcionario;
        Fornecedor fornecedor;
        Item item;
        Item item2;
        Item item3;
        Produto produto;
        
        Controlador controlador = new Controlador();
        
         do {
            controlador.exibirMenu();
            op = entrada.nextInt();
            
            switch(op){
                
                case 1:      
                    controlador.cadastrarCliente();
                    break;
                
                case 2:  
                    controlador.cadastrarFuncionario();
                    break;
                    
                case 3:
                    fornecedor = new Fornecedor();
                    System.out.println("Digite o CNPJ: ");
                    entrada.nextLine();
                    fornecedor.setCnpj(entrada.nextLine());
                    if(controlador.verificarCnpj(fornecedor) == true)
                    {
                        System.out.println("Fornecedor já cadastrado");
                        break;
                    }
                    fornecedor.adicionarDados();
                    controlador.cadastrarFornecedor(fornecedor);
                    break;
                    
                case 4:
                    item = new Item();
                    System.out.println("Digite o código do item: ");
                    entrada.nextLine();
                    item.setCodigo(entrada.nextInt());
                    if(controlador.verificarCodigoItem(item)== true)
                    {
                        System.out.println("Código já existente");
                        break;
                    }
                    item.adicionarDados();
                    controlador.cadastrarItem(item);
                    System.out.println("Item cadastrado com sucesso!");
                    break;
                    
                case 5:
                    System.out.println("Digite o código do produto: ");
                    entrada.nextLine();
                    int codigoProduto = entrada.nextInt();
                    if(controlador.verificarCodigoProduto(codigoProduto) == true)
                    {
                        System.out.println("Código já cadastrado");                        
                        break;
                    }
                    controlador.listarItens();
                    System.out.println("Digite o código do item que deseja adicionar: ");
                    entrada.nextLine();
                    int codigoItem = entrada.nextInt();
                    item2 = controlador.procurarItem(codigoItem);                   
                    produto = new Produto(codigoProduto, item2);
                    produto.adicionarDados();
                    controlador.cadastrarProduto(produto);
                    do{
                    System.out.println("Deseja adicionar mais algum item ao Produto? (1 - Sim 0 - Não)");
                    opcao = entrada.nextInt();
                    if(opcao == 1){
                        controlador.listarItens();
                        System.out.println("Digite o código do item a ser adicionado:");
                        int codigoItem2 = entrada.nextInt();
                        item3 = controlador.procurarItem(codigoItem2);
                        produto.adicionarItens(item3);                        
                    }
                    }while(opcao != 0);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                    
                case 6:
                    System.out.println("Digite o código do Item: ");
                    entrada.nextLine();
                    codigoItem = entrada.nextInt();
                    item = controlador.procurarItem(codigoItem);
                    if(controlador.verificarCodigoItem(item) == true)
                    {
                        item.editarDados();
                        controlador.editarItem(item);
                    }else{
                        System.out.println("Item não registrado no sistema!");
                        break;
                    }
                    System.out.println("Item alterado com sucesso!");
                    break;
                    
                case 7:
                    System.out.println("Digite o código do Produto: ");
                    entrada.nextLine();
                    codigoProduto = entrada.nextInt();
                    produto = controlador.procurarProduto(codigoProduto);
                    if(controlador.verificarCodigoProduto(codigoProduto) == true)
                    {                        
                        System.out.println("Deseja remover algum item? ");
                        entrada.nextLine();
                        int decisao = entrada.nextInt();
                        if(decisao == 1){
                            System.out.println("Digite o código do item a ser removido: ");
                            int codigoItem2 = entrada.nextInt();
                            item = controlador.procurarItem(codigoItem2);
                            produto.removerItens(item);
                        }
                        
                        System.out.println("Deseja adicionar algum item? ");
                        int decisao2 = entrada.nextInt();
                        if(decisao2 == 1){
                            controlador.listarItens();
                            System.out.println("Digite o código do item escolhido: ");
                            int codigoItem3 = entrada.nextInt();
                            item2 = controlador.procurarItem(codigoItem3);
                            produto.adicionarItens(item2);
                        }
                    }
                    produto.editarDados();
                    controlador.editarProduto(codigoProduto, produto);
                    controlador.listarProdutos();
                    break;
                    
                case 8:
                    controlador.removerCliente();
                    break;
                    
                case 9:
                    controlador.removerFuncionario();
                    break;
                    
                case 10:
                    controlador.removerFornecedor();
                    break;
                    
                case 11:
                    controlador.removerProduto();
                    break;                                    
            }
            
        }while (op != 0);
        System.exit(0);
    }
    
}
