package Controller;

import Model.DAO.FuncionarioDAO;
import Model.Funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaLoginController implements Initializable {   

    @FXML
    private AnchorPane frmTelaLogin;
    @FXML
    private Label lblAcessoRestrito;
    @FXML
    private Label lblUsuario;
    @FXML
    private Label lblSenha;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtSenha;
    @FXML
    private Button btnAcessar;
    @FXML
    private Button btnSair;
    @FXML
    private ImageView imgAcessoRestrito; 
    
    private String usuario;   
    private static Funcionario funcionario;   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }      
    
    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario func) {
        funcionario = func;
    }
    
    @FXML
    private void acessarMenuPrincipal(ActionEvent event) throws IOException {        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        usuario = txtUsuario.getText();        
        Stage stage = new Stage();
        setFuncionario(new FuncionarioDAO().selectOneByCpf(usuario));
        
        if(new FuncionarioDAO().selectOneByCpfLogin(usuario) != null){
            System.out.println("Passou pelo IF");
            Parent root = FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));            
            Scene scene = new Scene(root);            
            stage.setScene(scene);
            stage.setResizable(false);                                    
            stage.show();                                                
            stage.setTitle("Food Maker");            
            ProjetoLP3.fecharJanela(event);            
        }else{
            System.out.println("Passou pelo else");
            Parent root = FXMLLoader.load(getClass().getResource("/View/CadastrarFuncionario.fxml"));
            Scene scene = new Scene(root);            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();            
        }
    }

    @FXML
    private void encerrarSistema(ActionEvent event) {
        System.exit(0);
    }            
}
