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

    public static void main(String[] args) throws InterruptedException {
        //inicio de testes
        
        Log[] logs = new Log[4];
        //um log de cada tipo
        for(int i=0;i<4;i++)
        {
            System.out.println("Criando log " + i);
            logs[i] = new Log(i);
            
            for(int j=0;j<6;j++)
            {
                logs[i].adicionarPontoChecagem();
                Thread.sleep(2000); 
            }
        }
        for(int i=0;i<4;i++)
        {
            System.out.println("Log " + i);
            logs[i].exibirDados();
        }
            
        
        
            
        
        //fim de testes
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        
        Controlador controlador = new Controlador();
        
         do {
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
                    controlador.cadastrarItem();
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
            }
            
        }while (opcao != 0);
        System.exit(0);
    }
    
}
