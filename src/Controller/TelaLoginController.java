package Controller;

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
import javafx.scene.layout.VBox;
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
    private String senha;    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void acessarMenuPrincipal(ActionEvent event) throws IOException {        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        usuario = txtUsuario.getText();
        senha = txtSenha.getText();
        
        if(usuario.equals("admin") && senha.equals("admin")){
            Parent root = FXMLLoader.load(getClass().getResource("../View/MenuPrincipal.fxml"));            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);            
            stage.show();                                   
            ProjetoLP3.fecharJanela(event);            
        }else{
            alert.setContentText("Usuário não encontrado! Por favor, tente novamente!");
            alert.setTitle("Erro de Acesso!");
            alert.show();            
        }
    }

    @FXML
    private void encerrarSistema(ActionEvent event) {
        System.exit(0);
    }        
}
