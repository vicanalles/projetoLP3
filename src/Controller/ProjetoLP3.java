//comentário de teste

package Controller;

import Controller.Controlador;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjetoLP3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        Controlador controlador = new Controlador();
        
        do
        {
            controlador.exibirMenu();
            opcao = entrada.nextInt();
            
            switch(opcao){
                
                case 1:      
                    controlador.cadastrarCliente();
                    break;
                
                case 2:  
                    controlador.cadastrarFuncionario();
                    break;
                    
                case 3:                    
                    controlador.cadastrarFornecedor();
                    break;
                    
                case 4:
                    controlador.cadastrarCompra();
                    break;
                    
                case 5:
                    controlador.cadastrarProduto();
                    break;
                    
                case 6:
                    controlador.editarItem();
                    break;
                    
                case 7:
                    controlador.editarProduto();
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
                    
                case 12:
                    controlador.abrirPedido();
                    break;
                    
                case 13:
                    controlador.listarPedidos();
                    break;
                    
                case 14:
                    controlador.removerPedido();
                    break;
                    
                case 15:
                    controlador.adicionarChekpoint();
                    break;
                    
                case 16:
                    controlador.cadastrarItem();
                    break;
                    
                case 17:
                    controlador.listarProdutos();
                    break;
                    
                case 18:
                    controlador.listarItens();
                    break;
                    
                case 19:
                    controlador.listarClientes();
                    break;
                    
                case 20:
                    controlador.listarFuncionarios();
                    break;
                    
                case 21:
                    controlador.listarFornecedores();
                    break;
            }
        }while (opcao != 0);
        System.exit(0);
    }
    
}
